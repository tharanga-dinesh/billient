package com.lacodefy.billient.controller.income;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(InvoiceController.REQUEST_MAPPING_URL)
public class InvoiceController {

	public static final String REQUEST_MAPPING_URL = "/invoice";
	private static final String RESOURSE_MAP_PATH = "income/invoice/";

	@GetMapping("/")
	public ModelAndView index(final Model model, @ModelAttribute("success") final String success, @ModelAttribute("error") final String error) {
		final ModelAndView modelAndView = new ModelAndView(InvoiceController.RESOURSE_MAP_PATH + "home-view");
		model.addAttribute("success", success);
		model.addAttribute("error", error);
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
