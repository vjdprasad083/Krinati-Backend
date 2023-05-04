package com.kr.service;



import java.util.List;
import java.util.Map;

import javax.json.JsonObject;

import org.json.simple.JSONObject;

import com.kr.entities.JobExperience;
import com.kr.entities.Roles;

public interface JobExperienceService {
	
	JobExperience addJob(Roles roles,String companyName);
	
	Map<String, JSONObject> getJob();


}
