package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.ProjectModel;
import com.ngexsis.repository.ProjectRepo;
import com.ngexsis.model.TimePeriodModel;
import com.ngexsis.repository.TimePeriodRepo;

@Controller
public class ProjectController {

	@Autowired
	private ProjectRepo repo;
	
	@Autowired
	private TimePeriodRepo repo1;
	
	//handling utk request url localhost:port/project dan nampilin data
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String index(Model model) {
		
		//membuat object list mengenai data project kemudian diisi dari
		//object repo dengan method findAll
		List<ProjectModel> data = repo.findAll();
		
		//mengirim variabel listData, value nya diisi dari object data
		model.addAttribute("listData", data);
		
		//menampilkan view html src/resources/project sbg return
		return "project/index";
	}
	
	//handling untuk view tambah di url localhost:port/project/tambah
	//dan juga membawa data utk ditampilkan pada bagian dropdown dr tabel lain (tabel time period) 
	@RequestMapping(value = "/project/tambah")
	public String tambah(Model model) {
		
		List<TimePeriodModel> data1 = repo1.findAll();
		model.addAttribute("listTimePeriod", data1);
		
		//menampilkan view src/resources/templates/project
		return "/project/tambah";
	}
	
	//request utk handling simpan data ke dalam model ProjectModel
	@RequestMapping(value = "/project/simpan")
	public String simpan(@ModelAttribute ProjectModel item) {
		
		//mengirim item agar disimpan ke database
		repo.save(item);
		
		//redirect: akan diteruskan kembali ke halaman index project
		return "redirect:/project";
	}
	
	//request utk mengubah/edit data berdasarkan id spesifik
	@RequestMapping(value = "/project/ubah/{id}", method = RequestMethod.GET)
	public String ubah(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau diubah dalam ProjectModel dgn id spesifik
		ProjectModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari object item
		model.addAttribute("data", item);
		
		//utk tetap menampilkan bagian dropdown dr tabel lain (tabel time period)
		List<TimePeriodModel> data1 = repo1.findAll();
		model.addAttribute("listTimePeriod", data1);
		
		return "project/ubah";
	}
	
	//request halaman hapus yg ada di url localhost:port/project/hapus
	//dengan berdasarkan id spesifik, dengan menggunakan method get
	@RequestMapping(value = "/project/hapus/{id}", method = RequestMethod.GET)
	public String hapus(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau di hapus dalam ProjectModel dgn id spesifik
		ProjectModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari object item
		model.addAttribute("data", item);
		
		return "project/hapus";
	}
	
	//request delete data
	@RequestMapping(value = "/project/hapus", method = RequestMethod.POST)
	public String hapus(@ModelAttribute ProjectModel item) {
		
		//mengirim item agar dapat di delete
		item.setDelete(true);
		repo.save(item);
		
		return "redirect:/project";
	}
}
