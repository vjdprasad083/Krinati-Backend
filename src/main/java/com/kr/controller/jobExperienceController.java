package com.kr.controller;

import java.time.Period;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kr.entities.JobExperience;
import com.kr.entities.Roles;
import com.kr.service.JobExperienceService;

import io.swagger.v3.oas.annotations.media.Encoding;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class jobExperienceController {
	
	@Autowired
	private JobExperienceService service;
	
	
	@PostMapping("/jobs/roles/{company}")
	public ResponseEntity<JobExperience> addJob(@RequestBody Roles roles,@PathVariable String company){
		JobExperience jobRef= service.addJob(roles,company);
		return new ResponseEntity<JobExperience>(jobRef,HttpStatus.CREATED);
	}
	
	@GetMapping("/jobs")
	public ResponseEntity<Map<String, JSONObject>> getJobsByCompanyName(){
		Map<String, JSONObject> jobRef =service.getJob();
		return new ResponseEntity<Map<String, JSONObject>>(jobRef,HttpStatus.OK);
		
	}
	

}
