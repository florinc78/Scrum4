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
import com.scrum4.service.StorycatService;

@RestController
@EnableWebMvc
public class StorycatRestController {
	@Autowired
	private StorycatService storycatService;

	@RequestMapping(value = "/storycat/rest/{param}", method = RequestMethod.GET, produces = {
			"application/json" }, headers = { "Accept=text/xml, application/json" })
	public @ResponseBody Object getData(/*@PathVariable String param, @RequestParam("iSortCol_0") int iSortCol,
			@RequestParam("sSortDir_0") String sSortDir, @RequestParam("iDisplayStart") int iDisplayStart,
			@RequestParam("iDisplayLength") int iDisplayLength, @RequestParam("sEcho") int sEcho*/) {

//		System.out.println("iSortCol:" + iSortCol);
//		System.out.println("iDisplayStart:" + iDisplayStart);
//		System.out.println("iDisplayLength:" + iDisplayLength);
//		System.out.println("sEcho:" + sEcho);
//		System.out.println("sSortDir:" + sSortDir);

		PageData pageData = new PageData();
		pageData.setiDisplayStart(0);
		pageData.setiDisplayLength(10);
		pageData.setsEcho(1);
		pageData.setiSortCol_0(4);
		pageData.setsSortDir_0("desc");

		PagedItemsList dataTable = new PagedItemsList();
		dataTable = storycatService.getPage(pageData);

		return dataTable.getAaData();
	}

}
