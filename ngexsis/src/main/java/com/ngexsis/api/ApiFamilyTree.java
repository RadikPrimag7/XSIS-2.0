package com.ngexsis.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ngexsis.model.FamilyRelationModel;
import com.ngexsis.repository.FamilyRelationRepo;

@Controller
public class ApiFamilyTree {
	@Autowired
	private FamilyRelationRepo repo;
	
	private Log log = LogFactory.getLog(getClass());
	
	public ResponseEntity<List<FamilyRelationModel>> list(){
		ResponseEntity<List<FamilyRelationModel>> hasil = null;
		try {
			List<FamilyRelationModel> list = repo.findAll();
			hasil = new ResponseEntity<List<FamilyRelationModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug(e.getMessage(),e);
			hasil = new ResponseEntity<List<FamilyRelationModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
