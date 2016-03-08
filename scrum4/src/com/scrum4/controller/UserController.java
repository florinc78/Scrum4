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

import com.scrum4.model.beans.AppUser;
import com.scrum4.service.AppUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private AppUserService appUserService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(Model model) {
		logger.debug("listUsers");
        return "users";
    }
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String userAdd(Model model) {
    	AppUser appUser = new AppUser();
    	model.addAttribute("user", appUser);
        return "useradd";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String userEdit(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	AppUser appUser = new AppUser();
    	appUser.setUuid(uuid);
    	appUser = appUserService.get(appUser);
    	appUser.setDataInTr(appUser.getDataIn().getTime());
    	model.addAttribute("user", appUser);
        return "useradd";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
    public String userAddSubmit(@ModelAttribute("user") AppUser appUser) {
    	logger.debug("userAddSubmit");
    	if (appUser.getUuid()!=null){
    		Date dataIn =new Date();
    		dataIn.setTime(appUser.getDataInTr());
    		appUser.setDataIn(dataIn);
    		appUserService.edit(appUser);
    	} else {
    		appUserService.add(appUser);	
    	}
    	
    	return "redirect:list.html";
    }
    
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String userDel(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	AppUser appUser = new AppUser();
    	appUser.setUuid(uuid);
    	appUserService.delete(appUser);
    	System.out.println("userdel");
    	return "redirect:list.html";
    }
}
