package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.PelatihanModel;
import com.ngexsis.repository.PelatihanRepo;

@Controller
public class PelatihanController {
	@Autowired
	private PelatihanRepo repo;
	
	//tampil index
	@RequestMapping(value = "/pelatihan")
	public String detail(Model model) {
		//get semua data
		List<PelatihanModel> data = repo.findAll();
		model.addAttribute("listdata", data);
		return "pelatihan/detail";
	}
	
	//ke tambah
	@RequestMapping(value = "/tambah")
	public String tambah() {
		return "pelatihan/tambah";
	}
	
	//melakukan tambah data
	@RequestMapping(value ="/pelatihan/save", method = RequestMethod.POST)
	public String save(@ModelAttribute PelatihanModel item) {
		repo.save(item);
		return "redirect:/pelatihan";
	}
	
	//melakukan edit data
	@RequestMapping(value = "/pelatihan/edit/{id}", method = RequestMethod.GET)	
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		PelatihanModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "pelatihan/edit";
	}
	
	//ke halaman delete
	@RequestMapping(value = "/pelatihan/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model,@PathVariable(name ="id") Long id) {
		PelatihanModel item= repo.findById(id).orElse(null);
		model.addAttribute("data",item);
		return "pelatihan/delete";
	}
	
	//ngedelete data
	@RequestMapping(value = "/pelatihan/delete")
	public String hapus(@ModelAttribute PelatihanModel item) {
		repo.delete(item);
		return "redirect:/pelatihan";
	}
	

}

