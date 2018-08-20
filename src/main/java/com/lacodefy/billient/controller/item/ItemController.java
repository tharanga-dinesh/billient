package com.lacodefy.billient.controller.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(ItemController.REQUEST_MAPPING_URL)
public class ItemController {

	public static final String REQUEST_MAPPING_URL = "/item";
	private static final String RESOURSE_MAP_PATH = "item/";

	@GetMapping("/")
	public ModelAndView index(final Model model, @ModelAttribute("success") final String success, @ModelAttribute("error") final String error) {
		final ModelAndView modelAndView = new ModelAndView(ItemController.RESOURSE_MAP_PATH + "home-view");
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		return modelAndView;
	}

	@PostMapping("/add")
	public ModelAndView login(final Model model, final RedirectAttributes ra) {
		final ModelAndView modelAndView = new ModelAndView(ItemController.RESOURSE_MAP_PATH + "add-view");
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
