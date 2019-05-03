package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.CatatanModel;
import com.ngexsis.repository.CatatanRepo;

@Controller
public class CatatanController {
	//Auto instance dari repo
	@Autowired
	private CatatanRepo repo;
	
	@RequestMapping(value = "/catatan/index", method = RequestMethod.GET)
	public String index(Model model) {
		List<CatatanModel> data = repo.findAll();
		model.addAttribute("data", data);
		return "catatan/index";
	}
	
	//Add
	@RequestMapping("catatan/add")
	public String add() {
		return "catatan/add";
	}
	
	//Save
	@RequestMapping(value = "/catatan/save", method = RequestMethod.POST)
	public String save(@ModelAttribute CatatanModel item) {
		repo.save(item);
		return "redirect:/catatan/index";
	}
	
	//Edit
	@RequestMapping(value = "/catatan/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		CatatanModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "catatan/edit";
	}
	
	//Delete
	@RequestMapping(value = "/catatan/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable(name = "id") Long id) {
		CatatanModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "catatan/delete";
	}
	
	@RequestMapping(value = "/catatan/delete")
	public String hapus(@ModelAttribute CatatanModel item) {
		repo.delete(item);
		return "redirect:/catatan/index";
	}
}
