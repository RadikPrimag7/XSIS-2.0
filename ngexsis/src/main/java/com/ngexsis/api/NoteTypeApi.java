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

import com.ngexsis.model.NoteTypeModel;
import com.ngexsis.repository.NoteTypeRepo;

@Controller
public class NoteTypeApi {
	@Autowired
	private NoteTypeRepo repo;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/noteType/", method = RequestMethod.GET)
	public ResponseEntity<List<NoteTypeModel>> list(){
		ResponseEntity<List<NoteTypeModel>> hasil = null;
		try {
			List<NoteTypeModel> list = repo.findAll();
			hasil = new ResponseEntity<List<NoteTypeModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
