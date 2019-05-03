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

import com.ngexsis.model.MaritalStatusModel;
import com.ngexsis.repository.MaritalStatusRepo;

@Controller
public class MaritalStatusApi {

	@Autowired
	private MaritalStatusRepo repoMar;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/maritalStatus", method = RequestMethod.GET)
	public ResponseEntity<List<MaritalStatusModel>> list() {
		ResponseEntity<List<MaritalStatusModel>> hasil = null;
		try {
			List<MaritalStatusModel> list = repoMar.findAll();
			hasil = new ResponseEntity<List<MaritalStatusModel>> (list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
