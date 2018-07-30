package com.lacodefy.billient.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class WebGlobalExceptionHandler {

	@ExceptionHandler
	@ResponseBody
	public String handleException (Exception e, RedirectAttributes redirectAttributes) {
		e.printStackTrace();
		redirectAttributes.addAttribute("message", e.getCause().getMessage());
		return "";
	}
}
