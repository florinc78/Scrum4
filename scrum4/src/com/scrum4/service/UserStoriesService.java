package com.scrum4.service;

import com.scrum4.model.beans.UserStory;
import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;

public interface UserStoriesService {
	public PagedItemsList getPage(PageData pageData);
	
	public void add(UserStory userStory);
	
	public void edit(UserStory userStory);
	
	public UserStory get(UserStory userStory);
	
	public void delete(UserStory userStory);	
}
