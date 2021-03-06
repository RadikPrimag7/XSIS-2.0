package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.AddressModel;
import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.ReferensiModel;
import com.ngexsis.repository.AddressRepo;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.viewModel.BiodataForm;

@Controller
public class PelamarController {
	
	@Autowired
	private BiodataRepo repoBio;
	
	@Autowired
	private AddressRepo repoAddr;
	

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
	
	
	@RequestMapping(value="/pelamar/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveToPelamar(@RequestBody BiodataForm model) {
		
		BiodataModel item = model.getBiodata();
		
		repoBio.save(item);

		AddressModel addr = model.getAddress();
		
		addr.setBiodataId(item.getId());
		
		repoAddr.save(addr);
		
		
		return "redirect:/pelamar";
	}
	
	
	@RequestMapping(value="/pelamar/detail/{id}", method=RequestMethod.GET)
	public String detailPelamar(Model model, @PathVariable(name="id") Long id) {
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		
		model.addAttribute("data", item);
		
		return "/pelamar/detailPelamar";
	}
	
	@RequestMapping(value="/pelamar/token/{id}", method=RequestMethod.GET)
	public String token(Model model, @PathVariable(name="id") Long id) {
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		
		model.addAttribute("data", item);
		
		return "/pelamar/token";
	}
	
	@RequestMapping(value="/pelamar/savetoken", method=RequestMethod.POST)
	public String saveToken(@ModelAttribute BiodataModel item) {
		repoBio.save(item);
		return "redirect:/pelamar";
	}
}
