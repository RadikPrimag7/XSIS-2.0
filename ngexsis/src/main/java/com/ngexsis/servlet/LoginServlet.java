package com.ngexsis.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.ngexsis.model.UserModel;
import com.ngexsis.repository.UserRepo;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Autowired
	private UserRepo repo;

	protected void doPost(HttpServletRequest request, HttpServletResponse response, @RequestParam String email, @RequestParam String abpwd)
	throws ServletException, IOException{
		
		List<UserModel>data = repo.find(email, abpwd);
		String user = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		if(data.isEmpty()==true) {
			 request.getRequestDispatcher("login.html").include(request, response);  
		}
		else {
			HttpSession session= request.getSession();
			session.setAttribute(user, email);
			
			session.setMaxInactiveInterval(30*60);
			Cookie username = new Cookie("user", user);
			response.addCookie(username);
			
			String encodedURL = response.encodeRedirectURL("access.html");
			response.sendRedirect(encodedURL);
		}
	}
}
