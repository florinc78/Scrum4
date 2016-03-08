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
import com.scrum4.model.beans.UserStory;
import com.scrum4.model.dao.UserStoriesDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;


@Repository
public class UserStoriesDaoImpl implements UserStoriesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserStoriesDaoImpl(){
		
	}
	
    public UserStoriesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public PagedItemsList getPage(PageData pageData) {
		PagedItemsList pagedItemsList = new PagedItemsList(pageData);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserStory.class);
		criteria.setFirstResult(pageData.getiDisplayStart());
		criteria.setMaxResults(pageData.getiDisplayLength());
		System.out.println(UserStory.columns[pageData.getiSortCol_0()]);
		if (pageData.getsSortDir_0().equals("asc")) {
			criteria.addOrder(Order.asc(UserStory.columns[pageData.getiSortCol_0()]));
		} else {
			criteria.addOrder(Order.desc(UserStory.columns[pageData.getiSortCol_0()]));

		}

		@SuppressWarnings("unchecked")
		List<UserStory> userstoryList = criteria.list();

		Criteria criteriaCount = session.createCriteria(UserStory.class);
		criteriaCount.setProjection(Projections.rowCount());
		Long count = (Long) criteriaCount.uniqueResult();
		if (count == null){
			count = 0L;
		}
		session.getTransaction().commit();

		pagedItemsList.setAaData(userstoryList);
		pagedItemsList.setRecordsTotal(count.intValue());
		pagedItemsList.setRecordsFiltered(count.intValue());
		pagedItemsList.setDraw(1);
		return pagedItemsList;
	}

	@Override
	public void add(UserStory userStory) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userStory);
        session.getTransaction().commit();
	}

	@Override
	public UserStory get(UserStory userStory) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        userStory =  (UserStory)session.get(UserStory.class, userStory.getUuid());
        session.getTransaction().commit();
		return userStory;
	}

	@Override
	public void delete(UserStory userStory) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(userStory);
        session.getTransaction().commit();
	}

	@Override
	public void edit(UserStory userStory) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(userStory);
        session.getTransaction().commit();
	}
	
}
