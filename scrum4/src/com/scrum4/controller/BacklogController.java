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

import com.scrum4.model.beans.Backlog;
import com.scrum4.service.BacklogService;

@Controller
@RequestMapping(value="/backlog")
public class BacklogController {
	Logger logger = LoggerFactory.getLogger(BacklogController.class);
	@Autowired
	BacklogService backlogService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
		logger.debug("listBacklogs");
        return "listBacklogs";
    }

	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
		Backlog backlog = new Backlog();
    	model.addAttribute("backlog", backlog);
        return "addBacklogs";
    }
	
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	Backlog backlog = new Backlog();
    	backlog.setUuid(uuid);
    	
    	backlog = backlogService.get(backlog);
    	backlog.setDataInTr(backlog.getDataIn().getTime());
    	model.addAttribute("backlog", backlog);
        return "addBacklogs";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
    public String userAddSubmit(@ModelAttribute("backlog") Backlog backlog) {
    	if (backlog.getUuid()!=null){
    		Date dataIn =new Date();
    		dataIn.setTime(backlog.getDataInTr());
    		backlog.setDataIn(dataIn);
    		backlogService.edit(backlog);
    	} else {
    		backlogService.add(backlog);	
    	}
    	
    	return "redirect:list.html";
    }
    
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String userDel(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	Backlog backlog = new Backlog();
    	backlog.setUuid(uuid);
    	backlogService.delete(backlog);
    	return "redirect:list.html";
    }
}
