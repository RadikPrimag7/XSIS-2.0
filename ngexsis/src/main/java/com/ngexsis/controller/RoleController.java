package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.RoleModel;
import com.ngexsis.repository.RoleRepo;

@Controller
public class RoleController {
	
	@Autowired
	private RoleRepo repo;
	
	@RequestMapping("/role")
	public String index(Model model) {
		
		List<RoleModel> data = repo.findAll();
		model.addAttribute("listData", data);
		return "role/index";
	}
	
	@RequestMapping(value="role/add")
	public String add() {
		return "role/add";
	}
	
	@RequestMapping(value = "/role/save", method = RequestMethod.POST)
	public String save(@ModelAttribute RoleModel item) {
		repo.save(item);
		return "redirect:/role";
	}
	
	@RequestMapping(value = "/role/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		RoleModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "role/edit";
	}
	
	@RequestMapping(value="/role/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable(name="id") Long id) {
		
			RoleModel item = repo.findById(id).orElse(null);
			
			model.addAttribute("data", item);
			
		return "role/delete";
	}
	
	@RequestMapping(value = "/role/delete", method=RequestMethod.POST)
	public String hapus(@ModelAttribute RoleModel item) {
		
		repo.delete(item);
		
		return "redirect:/role";
	}
}
