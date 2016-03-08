package com.scrum4.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scrum4.model.beans.StoryCat;
import com.scrum4.model.dao.StorycatDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

@Repository
public class StorycatDaoImpl implements StorycatDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public StorycatDaoImpl() {
		super();
	}


	public StorycatDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@Override
	public PagedItemsList getPage(PageData pageData) {
		PagedItemsList pagedItemsList = new PagedItemsList(pageData);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(StoryCat.class);
		criteria.setFirstResult(pageData.getiDisplayStart());
		criteria.setMaxResults(pageData.getiDisplayLength());
		System.out.println(StoryCat.columns[pageData.getiSortCol_0()]);
		if (pageData.getsSortDir_0().equals("asc")) {
			criteria.addOrder(Order.asc(StoryCat.columns[pageData.getiSortCol_0()]));
		} else {
			criteria.addOrder(Order.desc(StoryCat.columns[pageData.getiSortCol_0()]));
		}

		@SuppressWarnings("unchecked")
		List<StoryCat> list = criteria.list();
		
		for (int i=0;i<list.size();i++){
			Hibernate.initialize(((StoryCat)(list.get(i))).getUserStories());
		}
		
		Criteria criteriaCount = session.createCriteria(StoryCat.class);
		criteriaCount.setProjection(Projections.rowCount());
		Long count = (Long) criteriaCount.uniqueResult();
		if (count == null){
			count = 0L;
		}
		session.getTransaction().commit();

		pagedItemsList.setAaData(list);
		pagedItemsList.setRecordsTotal(count.intValue());
		pagedItemsList.setRecordsFiltered(count.intValue());
		pagedItemsList.setDraw(1);
		return pagedItemsList;
	}

	@Override
	public void add(StoryCat appUser) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(appUser);
        session.getTransaction().commit();
	}

	@Override
	public StoryCat get(StoryCat storyCat) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        storyCat =  (StoryCat)session.get(StoryCat.class, storyCat.getUuid());
        session.getTransaction().commit();
		return storyCat;
	}

	@Override
	public void delete(StoryCat storyCat) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(storyCat);
        session.getTransaction().commit();
	}

	@Override
	public void edit(StoryCat storyCat) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(storyCat);
        session.getTransaction().commit();
		
	}
}
