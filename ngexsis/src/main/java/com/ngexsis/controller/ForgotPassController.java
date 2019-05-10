package com.ngexsis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ngexsis.model.UserModel;
import com.ngexsis.repository.UserRepo;

@Controller
public class ForgotPassController {

	private UserRepo repo;
	
	@RequestMapping(value="/password/forgot", method=RequestMethod.POST)
	public String forgotpass(Model model, @RequestParam String email) {
		List<UserModel> data= repo.findemail(email);
		model.addAttribute("listdata",data);
		
		if(data.isEmpty()==true) {
			return "redirect:/password?error=1";
		}
		return "/login";
		
	}
	
	@RequestMapping(value="/password/forgot", method=RequestMethod.GET)
	public String index() {
		return "password/forgot";
	}
	
	
}
