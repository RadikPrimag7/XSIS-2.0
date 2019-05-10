package com.ngexsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.KeahlianModel;
import com.ngexsis.model.PelatihanModel;
import com.ngexsis.model.PendidikanModel;
import com.ngexsis.model.PengalamanKerjaModel;
import com.ngexsis.model.SertifikasiModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.KeahlianRepo;
import com.ngexsis.repository.PelatihanRepo;
import com.ngexsis.repository.PendidikanRepo;
import com.ngexsis.repository.PengalamanKerjaRepo;
import com.ngexsis.repository.SertifikasiRepo;
import com.ngexsis.viewModel.ProfilForm;


@Controller
public class ProfilController {
	@Autowired
	private BiodataRepo bioRepo;
	@Autowired
	private PendidikanRepo pendRepo;
	@Autowired
	private PengalamanKerjaRepo pengalamanRepo;
	@Autowired
	private KeahlianRepo keahlianRepo;
	@Autowired
	private PelatihanRepo pelatihanRepo;
	@Autowired
	private SertifikasiRepo sertifikasiRepo;
	
	@RequestMapping(value="/profil")
	public String profil(Model model) {
		ProfilForm item = new ProfilForm();
		long id = 1;
		try {
			BiodataModel biodata = bioRepo.findById(id).orElse(null);
			item.setBiodata(biodata);
			PendidikanModel pendidikan = pendRepo.findById(id).orElse(null);
			item.setPendidikan(pendidikan);
			PengalamanKerjaModel pengalaman = pengalamanRepo.findById(id).orElse(null);
			item.setPengalaman(pengalaman);
			KeahlianModel keahlian = keahlianRepo.findById(id).orElse(null);
			item.setKeahlian(keahlian);
			PelatihanModel pelatihan = pelatihanRepo.findById(id).orElse(null);
			item.setPelatihan(pelatihan);
			SertifikasiModel sertifikasi = sertifikasiRepo.findById(id).orElse(null);
			item.setSertifikasi(sertifikasi);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("profil", item);
		
		return "profil/index";
	}
}
