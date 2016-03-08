package com.scrum4.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum4.model.beans.Backlog;
import com.scrum4.model.dao.BacklogDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;
import com.scrum4.service.BacklogService;

@Service
public class BacklogServiceImpl implements BacklogService {
	@Autowired
	private BacklogDao backlogDao;

	@Override
	public PagedItemsList getPage(PageData pageData) {
		return backlogDao.getPage(pageData);
	}

	@Override
	public void add(Backlog backlog) {
		Date date = new Date();
		backlog.setDataIn(date);
		backlog.setLastmodified(date);
		backlogDao.add(backlog);
	}

	@Override
	public void edit(Backlog backlog) {
		backlog.setLastmodified(new Date());
		backlogDao.edit(backlog);
		
	}

	@Override
	public Backlog get(Backlog backlog) {
		return backlogDao.get(backlog);
	}

	@Override
	public void delete(Backlog backlog) {
		backlogDao.delete(backlog);
	}

}
