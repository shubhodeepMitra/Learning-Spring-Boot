package com.example.springbootfirstwebapplication.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirstwebapplication.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	//@ResponseBody -> provides a view for Dispatcher Applet 
	public String showWelcomeMessage(ModelMap model) {
		//model.put("name", name);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showLoginPage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		boolean isValidUser = service.validateUser(name, password);
		if(!isValidUser) {
			model.put("errorMessage", "Invalid Credential");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}

} 
