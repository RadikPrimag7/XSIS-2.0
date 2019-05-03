package com.ngexsis.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngexsis.model.EducationLvlModel;
import com.ngexsis.repository.EducationLvlRepo;


@Controller
public class ApiEducationLvl {
	@Autowired
	private EducationLvlRepo repo;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/educationlvl/", method = RequestMethod.GET)
	public ResponseEntity<List<EducationLvlModel>> list(){
		ResponseEntity<List<EducationLvlModel>> hasil = null;
		try {
			List<EducationLvlModel> list = repo.findAll();
			hasil  = new ResponseEntity<List<EducationLvlModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
