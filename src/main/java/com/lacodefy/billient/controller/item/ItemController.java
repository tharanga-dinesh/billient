package com.lacodefy.billient.controller.item;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lacodefy.billient.controller.BaseController;
import com.lacodefy.billient.dto.item.ItemDTO;

@Controller
@RequestMapping(ItemController.REQUEST_MAPPING_URL)
public class ItemController extends BaseController{

	public final static String REQUEST_MAPPING_URL = "/item";
	private final static String RESOURSE_MAP_PATH = "item/";

	@GetMapping({"/", ""})
	public ModelAndView index(final Model model, @ModelAttribute("success") final String success, @ModelAttribute("error") final String error) {
		final ModelAndView modelAndView = new ModelAndView(ItemController.RESOURSE_MAP_PATH + "home-view");
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		model.addAttribute("pageTitle", "Item");
		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView addForm(final Model model, final RedirectAttributes ra) {
		model.addAttribute("pageTitle", "Item Add");
		try {
			setModelCommonData(model, new ItemDTO());
			return new ModelAndView(ItemController.RESOURSE_MAP_PATH + "add-view");
		} catch (final Exception e) {
			ra.addFlashAttribute("error", "Error While Loading Initial Data.");
			return new ModelAndView("redirect:/item/");
		}
	}

	@PostMapping("/save")
	public ModelAndView saveOrUpdate(final Model model, @ModelAttribute("item") @Valid final ItemDTO dto) {
		model.addAttribute("pageTitle", "Item Add");
		try {
			setModelCommonData(model, new ItemDTO());
			return new ModelAndView(ItemController.RESOURSE_MAP_PATH + "add-view");
		} catch (final Exception e) {
			model.addAttribute("error", "Error While Loading Initial Data.");
			return new ModelAndView(ItemController.RESOURSE_MAP_PATH + "add-view");
		}
	}

	//set common attribute for the model
	private void setModelCommonData(final Model model, final ItemDTO item) throws Exception {
		model.addAttribute("item",item);
	}

}
