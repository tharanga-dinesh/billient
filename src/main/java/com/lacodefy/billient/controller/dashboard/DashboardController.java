package com.lacodefy.billient.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(DashboardController.REQUEST_MAPPING_URL)
public class DashboardController {

	public static final String REQUEST_MAPPING_URL = "/dashboard";

	@GetMapping("/")
	public ModelAndView index(final Model model) {
		final ModelAndView modelAndView = new ModelAndView("dashboard/index");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(final Model model) {
		final ModelAndView modelAndView = new ModelAndView("login");
		setModelCommonData(model);
		return modelAndView;
	}

	//set common attribute for the model
	private void setModelCommonData(final Model model) {
		try {

		} catch (final Exception e) {
			e.printStackTrace();

		}
	}

}
