package com.ngexsis.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ngexsis.dao.AddrbookDAO;
import com.ngexsis.dao.RoleDAO;
import com.ngexsis.model.UserModel;





@Service
public class AddrbookDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private AddrbookDAO addrbookDAO;
	
    @Autowired
    private RoleDAO roleDAO;
   
 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel addrbook = this.addrbookDAO.findUserAccount(email);
 
        if (addrbook == null) {
            System.out.println("User not found! " + email);
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
 
        System.out.println("Found User: " + addrbook);
        
        if(addrbook.isLocked()==true) {
        	System.out.println("Account is locked " + email);
            throw new UsernameNotFoundException(email + " is locked.");
        }
        
       
        
        
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.roleDAO.getRoleNames(addrbook.getId());
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
        	for (String role : roleNames) {
        		// ROLE_USER, ROLE_ADMIN,..
        		GrantedAuthority authority = new SimpleGrantedAuthority(role);
        		grantList.add(authority);
        	}
        }
        
// 
        UserDetails userDetails = (UserDetails) new User(addrbook.getEmail(), //
                addrbook.getAbpwd(), grantList);
 
        return userDetails;
    }
 
}