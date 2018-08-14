package com.lacodefy.billient.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView; 

@Controller
public class HomeController {
	
	@GetMapping({"/","/index"})
	public ModelAndView index(Model model) { 
		ModelAndView modelAndView = new ModelAndView("dashboard/index");
		return modelAndView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(Model model) {
		ModelAndView modelAndView = new ModelAndView("login");
		setModelCommonData(model);
		return modelAndView;
	}
	
	//set common attribute for the model
	private void setModelCommonData(Model model) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
