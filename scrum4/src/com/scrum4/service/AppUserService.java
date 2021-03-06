package com.scrum4.service;

import com.scrum4.model.beans.AppUser;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

public interface AppUserService {
	public PagedItemsList getPage(PageData pageData);
	
	public void add(AppUser appUser);
	
	public void edit(AppUser appUser);
	
	public AppUser get(AppUser appUser);
	
	public void delete(AppUser appUser);
}
