package com.scrum4.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.scrum4.model.util.PageData;
import com.scrum4.model.util.PagedItemsList;
import com.scrum4.service.BacklogService;

@RestController
@EnableWebMvc
public class BacklogRestController {
	@Autowired
	private BacklogService backlogService;
	
	@RequestMapping(value = "/backlog/rest/{param}", method = RequestMethod.GET, produces={"application/json"},headers = {"Accept=text/xml, application/json"})
	public @ResponseBody Object  getData(@PathVariable String param
										, @RequestParam("iSortCol_0") int iSortCol
										, @RequestParam("sSortDir_0") String sSortDir
										, @RequestParam("iDisplayStart") int iDisplayStart
										, @RequestParam("iDisplayLength") int iDisplayLength
										, @RequestParam("sEcho") int sEcho){
		
		System.out.println("iSortCol:"+iSortCol);
		System.out.println("iDisplayStart:"+iDisplayStart);
		System.out.println("iDisplayLength:"+iDisplayLength);
		System.out.println("sEcho:"+sEcho);
		System.out.println("sSortDir:"+sSortDir);

		PageData pageData = new PageData();
		pageData.setiDisplayStart(iDisplayStart);
		pageData.setiDisplayLength(iDisplayLength);
		pageData.setsEcho(sEcho);
		pageData.setiSortCol_0(iSortCol);
		pageData.setsSortDir_0(sSortDir);
		
		PagedItemsList dataTable = new PagedItemsList();
		dataTable = backlogService.getPage(pageData);
		
		return dataTable;
	}
}
