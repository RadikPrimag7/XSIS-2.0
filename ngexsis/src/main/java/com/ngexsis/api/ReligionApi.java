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

import com.ngexsis.model.ReligionModel;
import com.ngexsis.repository.ReligionRepo;

@Controller
public class ReligionApi {
	
	@Autowired
	private ReligionRepo repoRel;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/religion", method = RequestMethod.GET)
	public ResponseEntity<List<ReligionModel>> list() {
		ResponseEntity<List<ReligionModel>> hasil = null;
		try {
			List<ReligionModel> list = repoRel.findAll();
			hasil = new ResponseEntity<List<ReligionModel>> (list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
