package com.scrum4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrum4.model.beans.StoryCat;
import com.scrum4.model.dao.StorycatDao;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;
import com.scrum4.service.StorycatService;

@Service
public class StorycatServiceImpl implements StorycatService{

	@Autowired
	StorycatDao storycatDao;

	@Override
	public PagedItemsList getPage(PageData pageData) {
		return storycatDao.getPage(pageData);
	}

	@Override
	public void add(StoryCat storyCat) {
		storycatDao.add(storyCat);
		
	}

	@Override
	public void edit(StoryCat storyCat) {
		storycatDao.edit(storyCat);		
	}

	@Override
	public StoryCat get(StoryCat storyCat) {
		return storycatDao.get(storyCat);
	}

	@Override
	public void delete(StoryCat storyCat) {
		storycatDao.delete(storyCat);
		
	}
	
	

}
