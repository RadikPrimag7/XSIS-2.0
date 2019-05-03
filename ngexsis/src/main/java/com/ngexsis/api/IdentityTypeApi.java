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

import com.ngexsis.model.IdentityTypeModel;
import com.ngexsis.repository.IdentityTypeRepo;

@Controller
public class IdentityTypeApi {
	
	@Autowired
	private IdentityTypeRepo repoIdType;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/identityType", method = RequestMethod.GET)
	public ResponseEntity<List<IdentityTypeModel>> list() {
		ResponseEntity<List<IdentityTypeModel>> hasil = null;
		try {
			List<IdentityTypeModel> list = repoIdType.findAll();
			hasil = new ResponseEntity<List<IdentityTypeModel>> (list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}

}
