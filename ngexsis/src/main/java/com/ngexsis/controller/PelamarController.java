package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.repository.BiodataRepo;

@Controller
public class PelamarController {
	
	@Autowired
	private BiodataRepo repoBio;
	

	@RequestMapping(value="/pelamar", method=RequestMethod.GET)
	public String index(Model model) {
		
		List<BiodataModel> item = repoBio.findAll();
		
		model.addAttribute("listData", item);
		
		return "/pelamar/index";
	}
	
	
	@RequestMapping(value="/pelamar/add")
	public String add() {
		
		return "/pelamar/add";
	}
	
	
	@RequestMapping(value="/pelamar/biodata/{id}", method=RequestMethod.GET)
	public String view(Model model, @PathVariable(name="id") Long id) {
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		
		model.addAttribute("data", item);
		
		return "/pelamar/biodata/index";
	}
	
}
