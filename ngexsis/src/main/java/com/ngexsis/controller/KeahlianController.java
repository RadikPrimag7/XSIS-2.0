package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.KeahlianModel;
import com.ngexsis.repository.KeahlianRepo;

@Controller
public class KeahlianController {
	//Membuat auto instance dari repository
	@Autowired
	private KeahlianRepo repo;
	
	@RequestMapping(value = "/keahlian/index", method = RequestMethod.GET)
	public String index(Model model) {
		List<KeahlianModel> data = repo.findAll();
		model.addAttribute("listData",data);
		return "keahlian/index";
	}
	
	@RequestMapping("keahlian/add")
	public String add() {
		return "keahlian/add";
	}
}
