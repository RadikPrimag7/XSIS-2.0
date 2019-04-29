package com.ngexsis.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.PengalamanKerjaModel;
import com.ngexsis.repository.PengalamanKerjaRepo;

@Controller
public class PengalamanKerjaController {

	//membuat auto instance dari repository
	@Autowired
	private PengalamanKerjaRepo repo;
	
	private Log log=LogFactory.getLog(getClass());
	
	@RequestMapping(value="/api/pengalaman/", method=RequestMethod.GET)
	public ResponseEntity<List<PengalamanKerjaModel>> list(){
		ResponseEntity<List<PengalamanKerjaModel>> hasil=null;
		try {
			List<PengalamanKerjaModel> list=repo.findAll();
			hasil =new ResponseEntity<List<PengalamanKerjaModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage(),e);
			hasil=new ResponseEntity<List<PengalamanKerjaModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
	
	
	@RequestMapping(value="/pengalaman/index")
	public String index(Model model) {
		List<PengalamanKerjaModel> data = repo.findAll();
		model.addAttribute("listData",data);
		return "pengalaman/index";
	}
	
	@RequestMapping(value="/pengalaman/add")
	public String add() {
		return "pengalaman/add";
	}
	
	
}
