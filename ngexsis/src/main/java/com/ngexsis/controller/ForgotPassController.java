package com.ngexsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.UserModel;
import com.ngexsis.repository.UserRepo;

@Controller
public class ForgotPassController {

	private UserRepo repo;
	
	@RequestMapping(value="/password/forgot", method=RequestMethod.GET)
	public String index() {
		return "password/forgot";
	}
}
