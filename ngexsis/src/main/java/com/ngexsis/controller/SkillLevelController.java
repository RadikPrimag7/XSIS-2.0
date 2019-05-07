package com.ngexsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ngexsis.model.SkillLevelModel;
import com.ngexsis.repository.SkillLevelRepo;

@Controller
public class SkillLevelController {
	@Autowired
	private SkillLevelRepo repo1;
	
	public String skillLevel(Model model) {
		List<SkillLevelModel> data = repo1.findAll();
		model.addAttribute("listSkill", data);
		return "keahlian/index";
	}
}
