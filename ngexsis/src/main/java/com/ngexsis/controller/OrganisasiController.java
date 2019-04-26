package com.ngexsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrganisasiController {
	
	@RequestMapping(value = "/organisasi", method = RequestMethod.GET)
	public String index() {
		return "organisasi/index";
	}
	
	public String tambah() {
		return "";
	}
	
	public String ubah() {
		return "";
	}
	
	public String delete() {
		return "";
	}
	
	public String simpan() {
		return "";
	}
}
