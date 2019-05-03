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

@Controller
public class ProjectController {

	@Autowired
	private ProjectRepo repo;
	
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
	@RequestMapping(value = "/project/tambah")
	public String tambah() {
		
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
	@RequestMapping(value = "/project/hapus")
	public String hapus(@ModelAttribute ProjectModel item) {
		
		//mengirim item agar dapat di delete dari database
		repo.delete(item);
		
		return "redirect:/project";
	}
}
