package com.ngexsis.controller;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.UserModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.RoleRepo;

@Controller
public class AccessController {

	
	@Autowired
	private BiodataRepo biorepo;
	
	@Autowired
	private RoleRepo rolerepo;
	
	
}
