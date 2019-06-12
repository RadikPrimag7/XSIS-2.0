package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.BiodataModel;
import com.ngexsis.model.OnlineTesModel;
import com.ngexsis.model.OnlineTestDetailModel;
import com.ngexsis.model.OnlineTestTypeModel;
import com.ngexsis.repository.BiodataRepo;
import com.ngexsis.repository.OnlineTesDetailRepo;
import com.ngexsis.repository.OnlineTesRepo;
import com.ngexsis.repository.OnlineTesTypeRepo;

@Controller
public class OnlineTesController {
	@Autowired BiodataRepo repoBio;
	@Autowired OnlineTesTypeRepo repoTypo;
	@Autowired OnlineTesDetailRepo repoDetail;
	@Autowired OnlineTesRepo repoTes;
	
	@RequestMapping(value = "pelamar/onlineTes/{id}")
	public String index(Model model, @PathVariable(name = "id")Long id ) {
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<OnlineTesModel> data = item.getListOnlineTes();
		model.addAttribute("listdata", data);
		
		return "AktivasiAkun/index";
	}
	
	@RequestMapping(value = "onlineTes/add/{id}")
	public String add(Model model, @PathVariable(name = "id")Long id) {
		
		List<OnlineTestDetailModel> data1 = repoDetail.findAll();
		model.addAttribute("listDetail", data1);
		
		BiodataModel item = repoBio.findById(id).orElse(null);
		model.addAttribute("itemBio", item);
		
		List<OnlineTestTypeModel> data = repoTypo.findAll();
		model.addAttribute("listDataType", data);
		
		List<OnlineTesModel> data2= repoTes.findAll();
		model.addAttribute("listTest", data2);
		
		return"AktivasiAkun/add";
	}
	
	@RequestMapping(value = "/onlineTes/save", method = RequestMethod.POST)
	public String save(@ModelAttribute OnlineTesModel item) {
		repoTes.save(item);
		return "redirect:/pelamar";
	}
}
