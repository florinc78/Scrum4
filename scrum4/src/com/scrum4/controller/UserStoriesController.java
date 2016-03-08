package com.scrum4.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scrum4.model.beans.UserStory;
import com.scrum4.service.UserStoriesService;

@Controller
@RequestMapping(value = "/userstories")
public class UserStoriesController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserStoriesService userStoriesService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model model) {
		logger.debug("list story cat");
		return "storylist";
	}
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String userAdd(Model model) {
    	UserStory userStory = new UserStory();
    	model.addAttribute("storycat", userStory);
        return "storyadd";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String userEdit(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	UserStory userStory = new UserStory();
    	userStory.setUuid(uuid);
    	userStory = userStoriesService.get(userStory);
    	userStory.setDataInTr(userStory.getDataIn().getTime());
    	model.addAttribute("userStory", userStory);
        return "storyadd";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
    public String userAddSubmit(@ModelAttribute("userStory") UserStory userStory) {
    	if (userStory.getUuid()!=null){
    		Date dataIn =new Date();
    		dataIn.setTime(userStory.getDataInTr());
    		userStory.setDataIn(dataIn);
    		userStoriesService.edit(userStory);
    	} else {
    		userStoriesService.add(userStory);	
    	}
    	
    	return "redirect:list.html";
    }
    
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String userDel(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	UserStory userStory = new UserStory();
    	userStory.setUuid(uuid);
    	userStoriesService.delete(userStory);
    	return "redirect:list.html";
    }

		
}
