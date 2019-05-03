package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.PendidikanModel;
import com.ngexsis.repository.PendidikanRepo;

@Controller
public class PendidikanController {
	
	@Autowired
	private PendidikanRepo repo;
	
	@RequestMapping("/pendidikan")
	public String index(Model model) {
		
		List<PendidikanModel> data = repo.findAll();
		model.addAttribute("listData", data);
		return "pendidikan/index";
	}
	
	@RequestMapping(value="pendidikan/add")
	public String add() {
		return "pendidikan/add";
	}
	
	@RequestMapping(value = "/pendidikan/save", method = RequestMethod.POST)
	public String save(@ModelAttribute PendidikanModel item) {
		repo.save(item);
		return "redirect:/pendidikan";
	}
	
	@RequestMapping(value = "/pendidikan/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		PendidikanModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "pendidikan/edit";
	}
	
	@RequestMapping(value="/pendidikan/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable(name="id") Long id) {
		
			PendidikanModel item = repo.findById(id).orElse(null);
			
			model.addAttribute("data", item);
			
		return "pendidikan/delete";
	}
	
	@RequestMapping(value = "/pendidikan/delete", method=RequestMethod.POST)
	public String hapus(@ModelAttribute PendidikanModel item) {
		
		repo.delete(item);
		
		return "redirect:/pendidikan";
	}
}
