package com.revature._611.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getHomepage() {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String getNotHomepage() {
		return "nothome";
	}
}