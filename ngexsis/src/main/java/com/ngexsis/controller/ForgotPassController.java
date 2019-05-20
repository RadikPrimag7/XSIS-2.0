package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ngexsis.model.UserModel;
import com.ngexsis.repository.UserRepo;

@Controller
public class ForgotPassController {

	@Autowired
	private UserRepo repo;
	
	@RequestMapping(value="/password/forgot",method=RequestMethod.POST)
	public String forgotpass(Model model, @RequestParam String email) {
		List<UserModel> data= repo.findemail(email);
		model.addAttribute("listdata",data);
		
		if(data.isEmpty()==true) {
			return "redirect:/password/index?error=1";
		}
		return "/login/index";
		
	}
	
	@RequestMapping(value="/password/index")
	public String index() {
		return "password/forgot";
	}
	
	
}
