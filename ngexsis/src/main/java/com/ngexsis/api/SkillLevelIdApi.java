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

import com.ngexsis.model.SkillLevelModel;
import com.ngexsis.repository.SkillLevelRepo;

@Controller
public class SkillLevelIdApi {
	@Autowired
	private SkillLevelRepo repo;
	
	private Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/api/skillLevel/", method = RequestMethod.GET)
	public ResponseEntity<List<SkillLevelModel>> list(){
		ResponseEntity<List<SkillLevelModel>> hasil = null;
		try {
			List<SkillLevelModel> list = repo.findAll();
			hasil  = new ResponseEntity<List<SkillLevelModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			hasil = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return hasil;
	}
}
