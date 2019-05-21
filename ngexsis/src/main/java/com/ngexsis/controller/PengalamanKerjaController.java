package com.ngexsis.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.PengalamanKerjaModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.PengalamanKerjaRepo;

@Controller
public class PengalamanKerjaController {

	//membuat auto instance dari repository
	@Autowired
	private PengalamanKerjaRepo repo;	
	
	@Autowired
	private BiodataRepo biorepo;
	
	@RequestMapping(value="pelamar/pengalaman/{id}")
	public String index(Model model, @PathVariable(name="id")Long id) {
		List<PengalamanKerjaModel> data = repo.findAll();
		model.addAttribute("listData",data);
		BiodataModel item=biorepo.findById(id).orElse(null);
		model.addAttribute("itemBio",item);
		return "pengalaman/index";
	}
	
	@RequestMapping(value="/pengalaman/add/{id}")
	public String add(Model model, @PathVariable(name="id") Long id) {
		
		BiodataModel item = biorepo.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<BiodataModel> dataBio = biorepo.findAll();
		model.addAttribute("listBio", dataBio);
		
		return "pengalaman/add";
	}
	
	//save ke model PengalamanKerjaModel
	@RequestMapping(value="/pengalaman/save", method=RequestMethod.POST)
	public String save(@ModelAttribute PengalamanKerjaModel item) {
		//mengirim item agar dapat disave ke database
		
		repo.save(item);
		return "redirect:/pengalaman";
	}
	
	@RequestMapping(value="/pengalaman/edit/{id}")
	public String edit(Model model, @PathVariable(name="id")Long id) {
		PengalamanKerjaModel item = repo.findById(id).orElse(null);
		
		model.addAttribute("data",item);
		
		List<BiodataModel> dataBio = biorepo.findAll();
		model.addAttribute("listBio1", dataBio);
		
		
		return "pengalaman/edit";
	}
	
	@RequestMapping(value="/pengalaman/delete/{id}",method= RequestMethod.GET)
	public String delete(Model model,@PathVariable(name="id")Long id) {
		PengalamanKerjaModel item=repo.findById(id).orElse(null);
		model.addAttribute("data",item);
		return "pengalaman/delete";
	}
	
	@RequestMapping(value="/pengalaman/delete", method=RequestMethod.POST)
	public String hapus(@ModelAttribute PengalamanKerjaModel item) {
		item.setDelete(true);
		repo.save(item);
		return "redirect:/pengalaman";
	}
	
}
