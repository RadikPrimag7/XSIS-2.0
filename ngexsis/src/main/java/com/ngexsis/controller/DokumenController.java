package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.DokumenModel;
import com.ngexsis.repository.DokumenRepo;

@Controller
public class DokumenController {

	@Autowired
	private DokumenRepo repo;
	
	//handling utk request url localhost:port/dokumen dan nampilin data
	@RequestMapping(value = "/dokumen", method = RequestMethod.GET)
	public String index(Model model) {
		
		//membuat object list mengenai data project kemudian diisi dari
		//object repo dengan method findAll
		List<DokumenModel> data = repo.findAll();
		
		//mengirim variabel listData, value nya diisi dari object data
		model.addAttribute("listData", data);
		
		//menampilkan view html src/resources.dokumen sbg return
		return "dokumen/index";
	}
	
	//handling utk view tambah di url localhost:port/dokumen/tambah
	@RequestMapping(value = "/dokumen/tambah")
	public String tambah() {
		
		//menampilkan view src/resources/templates/project
		return "/dokumen/tambah";
	}
	
	/*
	//handling upload file
	@RequestMapping(value = "/dokumen/tambah", method = RequestMethod.POST)
	public String unggah(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
		modelMap.addAttribute("file", file);
		return "/dokumen/tambah";
	}
	*/
	
	//request utk handling simpan data
	@RequestMapping(value = "/dokumen/simpan", method = RequestMethod.POST)
	public String simpan(@ModelAttribute DokumenModel item) {
		
		//mengirim item agar disimpan ke database
		repo.save(item);
		
		//redirect kembali ke halaman index dokumen
		return "redirect:/dokumen";
	}
	
	//request utk mengubah/edit data berdasarkan id spesifik
	@RequestMapping(value = "/dokumen/ubah/{id}", method = RequestMethod.GET)
	public String ubah(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau diubah dalam DokumenModel dgn id spesifik
		DokumenModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari object item
		model.addAttribute("data", item);
		
		return "dokumen/ubah";
	}
	
	//request halaman hapus yg ada di url localhost:port/dokumen/hapus
	//dgn berdasarkan id spesifik, dgn menggunakan method get
	@RequestMapping(value = "/dokumen/hapus/{id}", method = RequestMethod.GET)
	public String hapus(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau dihapus dalam DokumenModel dgn id spesifik
		DokumenModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari dari object item
		model.addAttribute("data", item);
		
		return "dokumen/hapus";
	}
	
	//request delete data
	@RequestMapping(value = "/dokumen/hapus")
	public String hapus(@ModelAttribute DokumenModel item) {
		
		//mengirim item agar dapat di delete dari database
		repo.delete(item);
		
		return "redirect:/dokumen";
	}
}
