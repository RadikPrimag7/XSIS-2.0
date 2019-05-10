package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.SumberLokerModel;
import com.ngexsis.model.VacancySauceModel;
import com.ngexsis.repository.SumberLokerRepo;
import com.ngexsis.repository.VacancySauceRepo;

@Controller
public class SumberLokerController {

	@Autowired
	private SumberLokerRepo repo;
	
	@Autowired
	private VacancySauceRepo repoSum;
	
	//tampil index
	@RequestMapping(value = "/sumberloker")
	public String detail(Model model) {
		//get semua data
		List<SumberLokerModel> data = repo.findAll();
		model.addAttribute("listdata", data);
		return "sumberloker/home";
	}
	
	//ke tambah
	@RequestMapping(value = "/sumberloker/add")
	public String tambah(Model model) {
		List<VacancySauceModel> data1 = repoSum.findAll();
		model.addAttribute("listdata1", data1);
		return "sumberloker/add";
	}
	
	//melakukan tambah data
	@RequestMapping(value ="/sumberloker/save", method = RequestMethod.POST)
	public String save(@ModelAttribute SumberLokerModel item) {
		repo.save(item);
		return "redirect:/sumberloker/add";
	}
	/*
	//melakukan edit data
	@RequestMapping(value = "/sumberloker/edit/{id}", method = RequestMethod.GET)	
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		SumberLokerModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "sumberloker/edit";
	}
	
	//ke halaman delete
	@RequestMapping(value = "/sumberloker/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model,@PathVariable(name ="id") Long id) {
		SumberLokerModel item= repo.findById(id).orElse(null);
		model.addAttribute("data",item);
		return "sumberloker/delete";
	}
	
	//ngedelete data
	@RequestMapping(value = "/sumberloker/delete")
	public String hapus(@ModelAttribute SumberLokerModel item) {
		repo.delete(item);
		return "redirect:/sumberloker";
	}
	*/

}
