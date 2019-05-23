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
import com.ngexsis.model.SertifikasiModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.SertifikasiRepo;

@Controller
public class SertifikasiController {
	@Autowired
	private SertifikasiRepo repo;
	
	@Autowired
	private BiodataRepo repoBio;
	
	@RequestMapping("/pelamar/sertifikasi/{id}")
	public String index(Model model, @PathVariable (name="id") Long id) {
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<SertifikasiModel> data = repo.findAll();
		model.addAttribute("listData", data);
		
		return "/sertifikasi/index";
	}
	
	@RequestMapping(value="/sertifikasi/add/{id}")
	public String add(Model model, @PathVariable(name="id") Long id) {
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		return "/sertifikasi/add";
	}
	
	@RequestMapping(value="/sertifikasi/save", method=RequestMethod.POST)
	public String save(@ModelAttribute SertifikasiModel item) {
		repo.save(item);
		return "redirect:/pelamar";
	}
	
	@RequestMapping(value="/sertifikasi/edit/{id}")
	public String edit(Model model, @PathVariable(name="id") Long id) {
		SertifikasiModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "sertifikasi/edit";
	}
	
	@RequestMapping(value="/sertifikasi/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable(name="id") Long id) {
		SertifikasiModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "sertifikasi/delete";
	}
	
	@RequestMapping(value="/sertifikasi/delete", method=RequestMethod.POST)
	public String hapus(@ModelAttribute SertifikasiModel item) {
		item.setDelete(true);
		repo.save(item);
		return "redirect:/sertifikasi";
	}
}
