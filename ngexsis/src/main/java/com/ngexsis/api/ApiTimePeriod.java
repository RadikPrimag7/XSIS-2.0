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

import com.ngexsis.model.TimePeriodModel;
import com.ngexsis.repository.TimePeriodRepo;

@Controller
public class ApiTimePeriod {
	@Autowired
	private TimePeriodRepo repo;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/timeperiod/", method = RequestMethod.GET)
	public ResponseEntity<List<TimePeriodModel>> list(){
		ResponseEntity<List<TimePeriodModel>> hasil = null;
		try {
			List<TimePeriodModel> list = repo.findAll();
			hasil  = new ResponseEntity<List<TimePeriodModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
