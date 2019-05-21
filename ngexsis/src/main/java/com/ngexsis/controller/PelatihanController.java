package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.PelatihanModel;
import com.ngexsis.model.TimePeriodModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.PelatihanRepo;
import com.ngexsis.repository.TimePeriodRepo;

@Controller
public class PelatihanController {
	@Autowired
	private PelatihanRepo repo;
	@Autowired
	private TimePeriodRepo repo1;
	@Autowired
	private BiodataRepo repoBio;
	
	//tampil index
	@RequestMapping(value = "/pelamar/pelatihan/{id}")
	public String detail(Model model, @PathVariable (name="id") Long id) {
		//get semua data
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<PelatihanModel> data = repo.findAll();
		model.addAttribute("listdata", data);
		
		return "pelatihan/detail";
	}
	
	//ke tambah
	@RequestMapping(value = "/tambah/{id}")
	public String tambah(Model model, @PathVariable(name = "id") Long id) {
		List<TimePeriodModel> data1 = repo1.findAll();
		model.addAttribute("listdata1",data1);
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<BiodataModel> dataBio = repoBio.findAll();
		model.addAttribute("listBio", dataBio);
		return "pelatihan/tambah";
	}
	
	//melakukan tambah data
	@RequestMapping(value ="/pelatihan/save", method = RequestMethod.POST)
	public String save(@ModelAttribute PelatihanModel item) {
		repo.save(item);
		return "redirect:/pelamar";
	}
	
	//melakukan edit data
	@RequestMapping(value = "/pelatihan/edit/{id}", method = RequestMethod.GET)	
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		PelatihanModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		
		List<TimePeriodModel> data1 = repo1.findAll();
		model.addAttribute("listdata2",data1);
		
		List<BiodataModel> dataBio = repoBio.findAll();
		model.addAttribute("listBio1", dataBio);
		
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

