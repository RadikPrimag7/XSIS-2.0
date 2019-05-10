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
import com.ngexsis.model.TimePeriodModel;
import com.ngexsis.repository.PelatihanRepo;
import com.ngexsis.repository.TimePeriodRepo;

@Controller
public class PelatihanController {
	@Autowired
	private PelatihanRepo repo;
	@Autowired
	private TimePeriodRepo repo1;
	
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
	public String tambah(Model model) {
		List<TimePeriodModel> data1 = repo1.findAll();
		model.addAttribute("listdata1",data1);
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
		
		List<TimePeriodModel> data1 = repo1.findAll();
		model.addAttribute("listdata2",data1);
		
		
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
		item.setDelete(true);
		repo.save(item);
		return "redirect:/pelatihan";
	}
	

}

