package com.ngexsis.controller;

import java.security.Principal;
import java.util.List;
import java.util.regex.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.ngexsis.model.UserModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.RoleRepo;
import com.ngexsis.repository.UserRepo;
import com.ngexsis.utils.WebUtils;

@Controller
public class LoginController {

//	@Autowired
//	private UserRepo repo;
//	
//	@RequestMapping(value="/login/access", method=RequestMethod.POST)
//	public String index(Model model,@RequestParam String email, @RequestParam String abupwd){
//		
//		List<UserModel>data = repo.find(email, abupwd);
//		model.addAttribute("listdata",data);
//		//data.get(0).getEmail();
//		if(data.isEmpty()==true) {
//			return "redirect:/login?error=1";
//		}
//		return "login/access";
//	}
//	@RequestMapping(value="/login")
//	public String login () {
//		return "login/index";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "login/index";
    }
    
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Logout");
        request.getSession().invalidate();
        return "login/logoutSuccessfulPage";
        
    }
	
	@RequestMapping(value = "/access", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal, HttpServletRequest request) {
		String userName = principal.getName();
		
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);
         
        System.out.println(session);
        return "login/access";
    }
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "login/403Page";
    }
	
}
