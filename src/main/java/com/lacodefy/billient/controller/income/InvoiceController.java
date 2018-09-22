package com.lacodefy.billient.controller.income;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lacodefy.billient.dto.income.invoice.InvoieDTO;

@Controller
@RequestMapping(InvoiceController.REQUEST_MAPPING_URL)
public class InvoiceController {

	public static final String REQUEST_MAPPING_URL = "/invoice";
	private static final String RESOURSE_MAP_PATH = "income/invoice/";

	@GetMapping("/")
	public ModelAndView index(final Model model, @ModelAttribute("success") final String success, @ModelAttribute("error") final String error) {
		model.addAttribute("success", success);
		model.addAttribute("error", error);
		model.addAttribute("pageTitle", "Invoices");
		return new ModelAndView(InvoiceController.RESOURSE_MAP_PATH + "home-view");
	}

	@GetMapping("/add")
	public ModelAndView login(final Model model, final RedirectAttributes ra) {
		model.addAttribute("pageTitle", "Invoice Add");
		try {
			setModelCommonData(model, new InvoieDTO());
			return new ModelAndView(InvoiceController.RESOURSE_MAP_PATH + "add-view");
		} catch (final Exception e) {
			ra.addFlashAttribute("error", "Error While Loading Initial Data.");
			return new ModelAndView("redirect:/invoice/");
		}
	}

	//set common attribute for the model
	private void setModelCommonData(final Model model, final InvoieDTO invoice) throws Exception {
		model.addAttribute("invoice", invoice);
	}

}
