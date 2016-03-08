package com.scrum4.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scrum4.model.beans.AppUser;
import com.scrum4.model.dao.AppUserDao;

@Controller
public class HelloWorld {

	@Autowired
	private AppUserDao appUserDao;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public String firstPage(Model model) {
    	System.out.println("page1");
        model.addAttribute("message", "This is the first page");
        return "firstpage";
    }
 
    @RequestMapping(value = "/page1add", method = RequestMethod.GET)
    public String firstPageAdd(Model model) {
    	System.out.println("page1add");
        return "firstpageadd";
    }
    
    @RequestMapping(value = "/page1edit", method = RequestMethod.GET)
    public String firstPageEdit(HttpServletRequest request, HttpServletResponse response, @RequestParam(name="uuid", required = false) UUID uuid) {
    	System.out.println("page1edit:"+uuid);
    	AppUser appUser = new AppUser();
    	appUser.setUuid(uuid);
    	appUser = appUserDao.get(appUser);
    	request.setAttribute("appUser", appUser);
    	
        return "firstpageadd";
    }
    
    @RequestMapping(value = "/page1add", method = RequestMethod.POST, headers = "Content-Type=application/x-www-form-urlencoded")
    public String firstPageAddSubmit(Model model, @RequestParam(name="userid", required = false) int userid, @RequestParam(required = false) String username) {
    	System.out.println("page1add post");
    	System.out.println("userid="+userid);
    	System.out.println("username="+username);

    	AppUser appUser = new AppUser();
    	appUser.setUserId(userid);
    	appUser.setUserName(username);
    	appUserDao.add(appUser);
    	
    	return "firstpage";
    }
    
    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public String secondPage(Model model) {
        model.addAttribute("message", "This is the second page");
        return "secondpage";
    }
}