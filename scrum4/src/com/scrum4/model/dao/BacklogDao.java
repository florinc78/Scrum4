package com.scrum4.model.dao;

import com.scrum4.model.beans.Backlog;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

public interface BacklogDao {
	public PagedItemsList getPage(PageData pageData);
	
	public void add(Backlog backlog);
	
	public void edit(Backlog backlog);
	
	public Backlog get(Backlog backlog);
	
	public void delete(Backlog backlog);	
}
