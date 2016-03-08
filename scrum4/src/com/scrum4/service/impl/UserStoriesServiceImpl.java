package com.scrum4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum4.model.beans.UserStory;
import com.scrum4.model.dao.UserStoriesDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;
import com.scrum4.service.UserStoriesService;

@Service
public class UserStoriesServiceImpl implements UserStoriesService {

	@Autowired
	private UserStoriesDao userStoriesDao;
	
	@Override
	public PagedItemsList getPage(PageData pageData) {
		return userStoriesDao.getPage(pageData);
	}

	@Override
	public void add(UserStory userStory) {
		userStoriesDao.add(userStory);
	}

	@Override
	public void edit(UserStory userStory) {
		userStoriesDao.edit(userStory);
	}

	@Override
	public UserStory get(UserStory userStory) {
		return userStoriesDao.get(userStory) ;
	}

	@Override
	public void delete(UserStory userStory) {
		userStoriesDao.delete(userStory);
	}
	
}
