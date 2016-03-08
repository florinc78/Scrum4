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

import com.scrum4.model.beans.StoryCat;
import com.scrum4.service.StorycatService;

@Controller
@RequestMapping(value = "/storycat")
public class StorycatController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private StorycatService storycatService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model model) {
		logger.debug("list story cat");
		return "storycatlist";
	}
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String userAdd(Model model) {
    	StoryCat storyCat = new StoryCat();
    	model.addAttribute("storycat", storyCat);
        return "storycatadd";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String userEdit(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	StoryCat storyCat = new StoryCat();
    	storyCat.setUuid(uuid);
    	storyCat = storycatService.get(storyCat);
    	storyCat.setDataInTr(storyCat.getDataIn().getTime());
    	model.addAttribute("storyCat", storyCat);
        return "storycatadd";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
    public String userAddSubmit(@ModelAttribute("storyCat") StoryCat storyCat) {
    	if (storyCat.getUuid()!=null){
    		Date dataIn =new Date();
    		dataIn.setTime(storyCat.getDataInTr());
    		storyCat.setDataIn(dataIn);
    		storycatService.edit(storyCat);
    	} else {
    		storycatService.add(storyCat);	
    	}
    	
    	return "redirect:list.html";
    }
    
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String userDel(Model model, @RequestParam(name="uuid", required = false) UUID uuid) {
    	StoryCat storyCat = new StoryCat();
    	storyCat.setUuid(uuid);
    	storycatService.delete(storyCat);
    	return "redirect:list.html";
    }
}
