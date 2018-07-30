package com.lacodefy.billient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping( value = {"/","/index"}, method = RequestMethod.GET )
	public String index(Model model) { 
		return "login";
	}
	
	@RequestMapping( value = "/login", method = RequestMethod.GET )
	public String login(Model model) {
		setModelCommonData(model);
		return "";
	}
	
	//set common attribute for the model
	private void setModelCommonData(Model model) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
