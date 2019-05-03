package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.ReferensiModel;
import com.ngexsis.repository.ReferensiRepo;

@Controller
public class ReferensiController {
	@Autowired
	private ReferensiRepo repo;
	
	@RequestMapping(value="/referensi")
	public String index(Model model) {
		List<ReferensiModel> data = repo.findAll();
		model.addAttribute("listData", data);
		return "/referensi/index";
	}
	
	@RequestMapping(value="/referensi/add")
	public String add() {
		return "/referensi/add";
	}
	
	@RequestMapping(value="/referensi/save", method=RequestMethod.POST)
	public String save(@ModelAttribute ReferensiModel item) {
		repo.save(item);
		return "redirect:/referensi";
	}
	
	@RequestMapping(value="/referensi/edit/{id}")
	public String edit(Model model, @PathVariable(name="id") Long id) {
		ReferensiModel item=repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "referensi/edit";
	}
	
	@RequestMapping(value="referensi/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable(name="id") Long id) {
		ReferensiModel item=repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "referensi/delete";
	}
	
	@RequestMapping(value="referensi/delete", method=RequestMethod.POST)
	public String hapus(@ModelAttribute ReferensiModel item) {
		repo.delete(item);
		return "redirect:/referensi";
	}
}
