package com.ngexsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfilController {
	@RequestMapping(value="/profil")
	public String profil() {
		return "profil/index";
	}
}
