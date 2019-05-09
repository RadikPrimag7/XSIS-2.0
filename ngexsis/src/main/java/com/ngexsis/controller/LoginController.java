package com.ngexsis.controller;

import java.util.List;
import java.util.regex.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.ngexsis.model.UserModel;
import com.ngexsis.repository.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private UserRepo repo;
	
	@RequestMapping(value="/login/index", method=RequestMethod.POST)
	public String index(Model model,@RequestParam String email, @RequestParam String abupwd){
		
		List<UserModel>data = repo.find(email, abupwd);
		model.addAttribute("listdata",data);
		
		//data.get(0).getEmail();

		if(data.isEmpty()==true) {
			return "redirect:/login?error=1";
		}
		
		return "login/access";
		
	}
	
	
	
	@RequestMapping(value="/login")
	public String login () {
		return "login/index";
	}
	
}
