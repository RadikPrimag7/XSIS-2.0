package com.ngexsis.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.ngexsis.model.UserModel;
import com.ngexsis.repository.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private UserRepo repo;
	
	private String email;
	private String abuid;
	private String abpwd;
	
	private Log log=LogFactory.getLog(getClass());
	
	@RequestMapping(value="/login/index", method=RequestMethod.GET)
	public String index(Model model,@PathVariable(name="id")Long id) {
		UserModel item=repo.findById(id).orElse(null);
		model.addAttribute("data",item);
		if(item==null) {
			System.out.println("invalid email/password");
			return "login/index";
		}
		else if(item.getEmail() == null) {
			System.out.println("invalid email/password");
			return "login/index";
		}
		else if(item.getEmail() != email && item.getAbpwd()!= abpwd) {
			System.out.println("invalid email/password");
			return "login/index";
		}
		else {
			return "login/access";
		}
		
	}
	
}
