package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.KeteranganTambahanModel;
import com.ngexsis.model.ReferensiModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.KeteranganTambahanRepo;
import com.ngexsis.repository.ReferensiRepo;


@Controller
public class LainLainController {
	@Autowired
	private BiodataRepo repoBio;
	
	@Autowired
	private ReferensiRepo repoRef;
	
	@Autowired
	private KeteranganTambahanRepo repoTam;
	
	@RequestMapping("/pelamar/lainlain/{id}")
	public String index(Model model, @PathVariable(name="id") Long id) {
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<ReferensiModel> dataRef = item.getListReferensi();
		model.addAttribute("listDataRef", dataRef);
		
		KeteranganTambahanModel dataTam = item.getListKetam();
		model.addAttribute("listDataTam", dataTam);
		
		return "/lainlain/index";
	}
	
	// Controller Referensi
	
	@RequestMapping(value="lainlain/addref/{id}")
	public String add(Model model, @PathVariable(name="id") Long id) {
		BiodataModel itemRef = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", itemRef);
		return "lainlain/addref";
	}
	
	@RequestMapping(value="lainlain/saveref", method=RequestMethod.POST)
	public String save(@ModelAttribute ReferensiModel item) {
		repoRef.save(item);
		return "redirect:/pelamar";
	}
	
	@RequestMapping(value="lainlain/editref/{id}")
	public String edit(Model model, @PathVariable(name="id") Long id) {
		ReferensiModel itemRef=repoRef.findById(id).orElse(null);
		model.addAttribute("dataRef", itemRef);
		return "lainlain/editref";
	}
	
	@RequestMapping(value="lainlain/deleteref/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable(name="id") Long id) {
		ReferensiModel itemRef=repoRef.findById(id).orElse(null);
		model.addAttribute("dataRef", itemRef);
		return "lainlain/deleteref";
	}
	
	@RequestMapping(value="lainlain/deleteref", method=RequestMethod.POST)
	public String hapus(@ModelAttribute ReferensiModel item) {
		item.setDelete(true);
		repoRef.save(item);
		return "redirect:/pelamar";
	}

	// Controller Keterangan Tambahan
	@RequestMapping(value="lainlain/viewketam/{id}")
	public String view(Model model, @PathVariable (name="id") Long id) {
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		KeteranganTambahanModel dataTam = item.getListKetam();
		model.addAttribute("dataTam", dataTam);
		return "lainlain/viewketam";
	}
	
	@RequestMapping(value="lainlain/editketam/{id}")
	public String tambah(Model model, @PathVariable (name="id") Long id) {
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		KeteranganTambahanModel dataTam = item.getListKetam();
		model.addAttribute("dataTam", dataTam);
		return "lainlain/editketam";
	}
	
	@RequestMapping(value="lainlain/saveketam", method=RequestMethod.POST)
	public String simpan(@ModelAttribute KeteranganTambahanModel item) {
		repoTam.save(item);
		return "redirect:/pelamar";
	}
	
	/*
	@RequestMapping(value="/lainlain/viewketam")
	public String view(Model model) {
		List<KeteranganTambahanModel> dataTam=repoTam.findAll();
		model.addAttribute("listDatatam", dataTam);
		
		return "/lainlain/viewketam";
	}
	
	@RequestMapping(value="lainlain/editketam")
	public String tambah() {
		return "lainlain/editketam";
	}
	
	@RequestMapping(value="lainlain/saveketam", method=RequestMethod.POST)
	public String simpan(@ModelAttribute KeteranganTambahanModel itemTam) {
		repoTam.save(itemTam);
		return "redirect:/lainlain";
	}
	
	@RequestMapping(value="lainlain/editketam/{id}")
	public String ubah(Model model, @PathVariable(name="id") Long id) {
		KeteranganTambahanModel itemTam=repoTam.findById(id).orElse(null);
		model.addAttribute("dataTam", itemTam);
		return "lainlain/editketam";
	}
	*/
}
