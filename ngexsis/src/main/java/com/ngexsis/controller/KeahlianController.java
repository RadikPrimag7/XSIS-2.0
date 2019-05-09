package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.KeahlianModel;
import com.ngexsis.model.SkillLevelModel;
import com.ngexsis.repository.KeahlianRepo;
import com.ngexsis.repository.SkillLevelRepo;

@Controller
public class KeahlianController {
	//Membuat auto instance dari repository
	@Autowired
	private KeahlianRepo repo;
	@Autowired
	private SkillLevelRepo repo1;
	
	@RequestMapping(value = "/keahlian/index", method = RequestMethod.GET)
	public String index(Model model) {
		List<KeahlianModel> data = repo.findAll();
		model.addAttribute("listData",data);
		return "keahlian/index";
	}
	
	@RequestMapping("/keahlian/add")
	public String add(Model model) {
		List<SkillLevelModel> data1 = repo1.findAll();
		model.addAttribute("listSkill", data1);
		return "keahlian/add";
	}
	
	//Save data ke dalam model keahlian
	//Dengan menggunakan method post
	@RequestMapping(value = "/keahlian/save", method = RequestMethod.POST)
	public String save(@ModelAttribute KeahlianModel item) {
		//Simpan ke database
		repo.save(item);
		//Akan diteruskan ke halaman index
		return "redirect:/keahlian/index";
	}
	
	//Edit dengan id spesifik
	@RequestMapping(value="/keahlian/edit/{id}")
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		//Mencari item yang mau di edit dari model keahlian
		KeahlianModel item = repo.findById(id).orElse(null);
		//Mengirim variable data, value diisi dari object item
		model.addAttribute("data", item);
		
		List<SkillLevelModel> data1 = repo1.findAll();
		model.addAttribute("skillLvl", data1);
//		
//		SkillLevelModel item1 = repo1.findById(id).orElse(null);
//		model.addAttribute("data1", item1);
		 
		return "keahlian/edit";
	}
	
	//Request halaman delete yang ada di url localhost:port/keahlian/delete
	@RequestMapping(value="/keahlian/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable(name = "id") Long id) {
		//Mencari data yang mau di delete
		KeahlianModel item = repo.findById(id).orElse(null);
		//Mengirim variable data, value diisi dari object item
		model.addAttribute("data", item);
		return "keahlian/delete";
	}
	
	//Request delete data
	@RequestMapping(value = "/keahlian/delete", method = RequestMethod.POST)
	public String hapus(@ModelAttribute KeahlianModel item) {
		//Mengirim item agar dapat di delete dari database
		repo.delete(item);
		
		return "redirect:/keahlian/index";
	}
	
}
