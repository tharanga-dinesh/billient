package com.lacodefy.billient.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(UserController.REQUEST_MAPPING_URL)
public class UserController {

	public static final String REQUEST_MAPPING_URL = "/user";

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOutView (final Model model) {
		return "login";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileView (final Model model) {
		return "user/profile";
	}

	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String settingView (final Model model) {
		return "user/setting";
	}

}
