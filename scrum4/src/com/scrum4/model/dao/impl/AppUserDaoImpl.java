package com.scrum4.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scrum4.model.beans.AppUser;
import com.scrum4.model.dao.AppUserDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

@Repository
public class AppUserDaoImpl implements AppUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public AppUserDaoImpl(){
		
	}
	
    public AppUserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public PagedItemsList getPage(PageData pageData) {
		PagedItemsList pagedItemsList = new PagedItemsList(pageData);
		
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(AppUser.class);
        criteria.setFirstResult(pageData.getiDisplayStart());
        criteria.setMaxResults(pageData.getiDisplayLength());
        if (pageData.getsSortDir_0().equals("asc")){
        	criteria.addOrder(Order.asc(AppUser.columns[pageData.getiSortCol_0()]));
        } else {
        	criteria.addOrder(Order.desc(AppUser.columns[pageData.getiSortCol_0()]));	
        
        }
        @SuppressWarnings("unchecked")
		List<AppUser> appUserList = criteria.list();
        
        Criteria criteriaCount = session.createCriteria(AppUser.class);
        criteriaCount.setProjection(Projections.rowCount());
        Long count = (Long)criteriaCount.uniqueResult();

        session.getTransaction().commit();

		pagedItemsList.setAaData(appUserList);
		pagedItemsList.setRecordsTotal(count.intValue());
		pagedItemsList.setRecordsFiltered(count.intValue());
		pagedItemsList.setDraw(1);
		return pagedItemsList;
	}

	@Override
	public void add(AppUser appUser) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(appUser);
        session.getTransaction().commit();
	}

	@Override
	public AppUser get(AppUser appUser) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        appUser =  (AppUser)session.get(AppUser.class, appUser.getUuid());
        session.getTransaction().commit();
		return appUser;
	}

	@Override
	public void delete(AppUser appUser) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(appUser);
        session.getTransaction().commit();
	}

	@Override
	public void edit(AppUser appUser) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(appUser);
        session.getTransaction().commit();
		
	}
	
}
