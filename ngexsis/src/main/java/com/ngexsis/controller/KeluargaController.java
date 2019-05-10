package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.EducationLvlModel;
import com.ngexsis.model.FamilyRelationModel;
import com.ngexsis.model.FamilyTreeModel;
import com.ngexsis.model.KeluargaModel;
import com.ngexsis.repository.EducationLvlRepo;
import com.ngexsis.repository.FamilyRelationRepo;
import com.ngexsis.repository.FamilyTreeRepo;
import com.ngexsis.repository.KeluargaRepo;

@Controller
public class KeluargaController {
	
	@Autowired
	private KeluargaRepo repo;
	
	@Autowired
	private FamilyTreeRepo repoTree;
	
	@Autowired
	private FamilyRelationRepo repoRelasi;
	
	@Autowired
	private EducationLvlRepo repoEdu;
	
	@RequestMapping (value = "/keluarga")
	public String index(Model model) {
		List<KeluargaModel> data = repo.findAll();
		model.addAttribute("listdata",data);
		return "keluarga/index";
		
	}
	
	@RequestMapping(value = "/add")
	public String add(Model model) {
		List<FamilyTreeModel> data = repoTree.findAll();
		model.addAttribute("listdataTree",data);
		
		List<FamilyRelationModel> data1 = repoRelasi.findAll();
		model.addAttribute("listdataRelasi",data1);
		
		List<EducationLvlModel> data2 = repoEdu.findAll();
		model.addAttribute("listdataEdu",data2);
		return "keluarga/add";
	}
	
	@RequestMapping(value = "/keluarga/save", method = RequestMethod.POST)
	public String save(@ModelAttribute KeluargaModel item) {
		repo.save(item);
		return "redirect:/keluarga";
	}
	
	@RequestMapping(value = "/keluarga/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable(name = "id") Long id) {
		KeluargaModel item=repo.findById(id).orElse(null);
		model.addAttribute("data",item);
		
		List<FamilyTreeModel> data = repoTree.findAll();
		model.addAttribute("listdataTree1",data);
		
		List<FamilyRelationModel> data1 = repoRelasi.findAll();
		model.addAttribute("listdataRelasi",data1);
		
		List<EducationLvlModel> data2 = repoEdu.findAll();
		model.addAttribute("listdataEdu",data2);
		
		return "keluarga/edit";
	}
	
	@RequestMapping(value = "/keluarga/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable(name = "id") Long id) {
		KeluargaModel item = repo.findById(id).orElse(null);
		model.addAttribute("data", item);
		return "keluarga/delete";
		
	}
	
	@RequestMapping(value="/keluarga/delete")
	public String hapus(@ModelAttribute KeluargaModel item) {
		item.setDelete(true);
		repo.save(item);
		return "redirect:/keluarga";
	}
	
}
