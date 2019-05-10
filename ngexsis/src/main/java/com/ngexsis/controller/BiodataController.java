package com.ngexsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.AddressModel;
import com.ngexsis.model.BiodataModel;
import com.ngexsis.repository.AddressRepo;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.viewModel.BiodataForm;

@Controller
public class BiodataController {

	@Autowired
	private BiodataRepo repoBio;
	
	@Autowired
	private AddressRepo repoAddr;
	
	
	@RequestMapping(value="/pelamar/biodata/{id}", method=RequestMethod.GET)
	public String index(Model model, @PathVariable(name="id") Long id) {
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		
		model.addAttribute("data", item);
		
		return "/pelamar/biodata/index";
	}
	
	
	@RequestMapping(value="/pelamar/biodata/edit/{id}", method=RequestMethod.GET)
	public String edit(Model model, @PathVariable(name="id") Long id) {
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		
		model.addAttribute("data", item);
		
		return "/pelamar/biodata/edit";
	}
	
		
	@RequestMapping(value="/pelamar/biodata/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveToBiodata(@RequestBody BiodataForm model) {
		
		BiodataModel item = model.getBiodata();
		
		repoBio.save(item);

		AddressModel addr = model.getAddress();
		
		addr.setBiodataId(item.getId());
		
		repoAddr.save(addr);
		
		
		return "redirect:/pelamar/biodata/{id}";
	}
	
}
