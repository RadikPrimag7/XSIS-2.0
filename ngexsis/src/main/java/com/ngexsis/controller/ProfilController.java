package com.ngexsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.PendidikanModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.PendidikanRepo;
import com.ngexsis.viewModel.ProfilForm;


@Controller
public class ProfilController {
	@Autowired
	private BiodataRepo bioRepo;
	@Autowired
	private PendidikanRepo pendRepo;
	
	@RequestMapping(value="/profil")
	public String profil(Model model) {
		ProfilForm item = new ProfilForm();
		long id = 1;
		try {
			BiodataModel biodata = bioRepo.findById(id).orElse(null);
			item.setBiodata(biodata);
			PendidikanModel pendidikan = pendRepo.findById(id).orElse(null);
			item.setPendidikan(pendidikan);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("profil", item);
		
		return "profil/index";
	}
}
