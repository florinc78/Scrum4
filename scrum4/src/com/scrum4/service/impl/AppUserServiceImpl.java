package com.scrum4.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum4.model.beans.AppUser;
import com.scrum4.model.dao.AppUserDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;
import com.scrum4.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDao appUserDao;
	
	@Override
	public PagedItemsList getPage(PageData pageData) {
		return appUserDao.getPage(pageData);
	}

	@Override
	public void add(AppUser appUser) {
		Date date = new Date();
		appUser.setDataIn(date);
		appUser.setLastmodified(date);
		appUserDao.add(appUser);
		
	}

	@Override
	public void edit(AppUser appUser) {
		appUser.setLastmodified(new Date());
		appUserDao.edit(appUser);
	}

	@Override
	public AppUser get(AppUser appUser) {
		return appUserDao.get(appUser);
	}

	@Override
	public void delete(AppUser appUser) {
		appUserDao.delete(appUser);
	}

}
