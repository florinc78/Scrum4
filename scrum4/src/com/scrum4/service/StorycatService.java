package com.scrum4.service;

import com.scrum4.model.beans.StoryCat;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

public interface StorycatService {
	public PagedItemsList getPage(PageData pageData);
	
	public void add(StoryCat storyCat);
	
	public void edit(StoryCat storyCat);
	
	public StoryCat get(StoryCat storyCat);
	
	public void delete(StoryCat storyCat);	
}
