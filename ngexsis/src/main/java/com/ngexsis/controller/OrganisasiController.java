package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.OrganisasiModel;
import com.ngexsis.repository.OrganisasiRepo;

@Controller
public class OrganisasiController {
	
	@Autowired
	private OrganisasiRepo repo;
	
	//handling utk request url localhost:port/organisasi dan nampilin semua data
	@RequestMapping(value = "/organisasi", method = RequestMethod.GET)
	public String index(Model model) {
		
		//membuat object list mengenai data organisasi, kemudian diisi dari 
		//object repo dengan method findAll
		List<OrganisasiModel> data = repo.findAll();
		
		//mengirim variabel listData, value-nya diisi dari object data
		model.addAttribute("listData", data);
		
		//menampilkan view src/resources/template/organisasi
		return "organisasi/index";
	}
	
	//handling utk view tambah di url localhost:port/organisasi/tambah
	@RequestMapping(value = "/organisasi/tambah")
	public String tambah() {
		
		//menampilkan view src/resources/templates/organisasi
		return "/organisasi/tambah";
	}
	
	//request utk handling simpan data ke dalam model OrganisasiModel
	@RequestMapping(value = "/organisasi/simpan", method = RequestMethod.POST)
	public String simpan(@ModelAttribute OrganisasiModel item) {
		
		//mengirim item agar disimpan ke database
		repo.save(item);
		
		//redirect: akan diteruskan kembali ke halaman index
		return "redirect:/organisasi";
	}
	
	//request mengubah/edit data berdasarkan id spesifik
	@RequestMapping(value = "/organisasi/ubah/{id}", method = RequestMethod.GET)
	public String ubah(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau di ubah dalam OrganisasiModel dengan id spesifik
		OrganisasiModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari object item
		model.addAttribute("data", item);
		
		return "organisasi/ubah";
	}
	
	//request halaman hapus yg ada di url localhost:port/organisasi/hapus
	//dengan berdasarkan id spesifik, dengan menggunakan method get
	@RequestMapping(value = "/organisasi/hapus/{id}", method = RequestMethod.GET)
	public String hapus(Model model, @PathVariable(name = "id") Long id) {
		
		//mencari data yg mau di delete dalam OrganisasiModel dengan id spesifik
		OrganisasiModel item = repo.findById(id).orElse(null);
		
		//mengirim variabel data, value diisi dari object item
		model.addAttribute("data", item);
		
		return "organisasi/hapus";
	}
	
	//request delete data
	@RequestMapping(value = "/organisasi/hapus")
	public String hapus(@ModelAttribute OrganisasiModel item) {
		
		//mengirim item agar dapat di delete dari database
		repo.delete(item);
		
		return "redirect:/organisasi";
	}
	
}
