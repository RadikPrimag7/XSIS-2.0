package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.KeluargaModel;
import com.ngexsis.repository.KeluargaRepo;

@Controller
public class KeluargaController {
	
	@Autowired
	private KeluargaRepo repo;
	
	@RequestMapping (value = "/keluarga")
	public String index(Model model) {
		List<KeluargaModel> data = repo.findAll();
		model.addAttribute("listdata",data);
		return "keluarga/index";
		
	}
	
	@RequestMapping(value = "/add")
	public String add() {
		
		return "keluarga/add";
	}
	
	@RequestMapping(value = "/keluarga/add", method = RequestMethod.POST)
	public String save(@ModelAttribute KeluargaModel item) {
		repo.save(item);
		return "redirect: /keluarga";
	}
	
	@RequestMapping(value = "/keluarga/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		KeluargaModel item=repo.findById(id).orElse(null);
		model.addAttribute("data",item);
		return "keluarga/edit";
	}
	
	@RequestMapping(value = "/keluarga/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable(name = "id") Long id) {
		KeluargaModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "keluarga/delete";
		
	}
	
	@RequestMapping(value="/keluarga/delete")
	public String hapus(@ModelAttribute KeluargaModel item) {
		repo.delete(item);
		return "redirect:/keluarga";
	}
	
}
