package com.scrum4.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scrum4.model.beans.Backlog;
import com.scrum4.model.dao.BacklogDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

@Repository
public class BacklogDaoImpl implements BacklogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PagedItemsList getPage(PageData pageData) {
		PagedItemsList pagedItemsList = new PagedItemsList(pageData);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Backlog.class);
		criteria.setFirstResult(pageData.getiDisplayStart());
		criteria.setMaxResults(pageData.getiDisplayLength());
		System.out.println(Backlog.columns[pageData.getiSortCol_0()]);
		if (pageData.getsSortDir_0().equals("asc")) {
			criteria.addOrder(Order.asc(Backlog.columns[pageData.getiSortCol_0()]));
		} else {
			criteria.addOrder(Order.desc(Backlog.columns[pageData.getiSortCol_0()]));

		}

		@SuppressWarnings("unchecked")
		List<Backlog> backlogList = criteria.list();

		Criteria criteriaCount = session.createCriteria(Backlog.class);
		criteriaCount.setProjection(Projections.rowCount());
		Long count = (Long) criteriaCount.uniqueResult();
		if (count == null){
			count = 0L;
		}
		session.getTransaction().commit();

		pagedItemsList.setAaData(backlogList);
		pagedItemsList.setRecordsTotal(count.intValue());
		pagedItemsList.setRecordsFiltered(count.intValue());
		pagedItemsList.setDraw(1);
		return pagedItemsList;
	}

	@Override
	public void add(Backlog backlog) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(backlog);
        session.getTransaction().commit();

	}

	@Override
	public void edit(Backlog backlog) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(backlog);
        session.getTransaction().commit();

	}

	@Override
	public Backlog get(Backlog backlog) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        backlog =  (Backlog)session.get(Backlog.class, backlog.getUuid());
        session.getTransaction().commit();
		return backlog;
	}

	@Override
	public void delete(Backlog backlog) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(backlog.getUuid());
        session.getTransaction().commit();

	}

}
