package com.ngexsis.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.ngexsis.repository.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private UserRepo repo;
	
	private Log log=LogFactory.getLog(getClass());
	
	@RequestMapping(value="/login/index")
	public String index(Model model, String error, String logout) {
		if(error!=null) {
			model.addAttribute("error","your username and password is invalid");
		}
		if(logout!=null) {
			model.addAttribute("message","You have been logged out successfully");
		}
		return "login/index";
	}
	
	
	public String access() {
		return "select/access";
	}
	
	
}
