package com.kr.serviceImpl;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kr.entities.JobExperience;
import com.kr.entities.Roles;
import com.kr.repo.JobExperienceRepo;
import com.kr.repo.RoleRepo;
import com.kr.service.JobExperienceService;
import com.kr.url.Urls;

@Service
public class JobExperienceServiceImpl implements JobExperienceService {
	
	@Autowired
	private JobExperienceRepo jobExperienceRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	
	@Override
	public JobExperience addJob(Roles roles, String companyName) {
		if (roles.getEndDate() == null) {
			roles.setEndDate(LocalDate.now());
			Period period = Period.between(roles.getStartDate(), roles.getEndDate());
			roles.setPeriod(period);
		} else {
			Period period = Period.between(roles.getStartDate(), roles.getEndDate());
			roles.setPeriod(period);
		}
		JobExperience job = new JobExperience();
		job.setCompanyName(companyName);
		job.setImg(Urls.getUrlByCompany(companyName));
		job.setTotalPeriod(Period.between(roles.getStartDate(), roles.getEndDate()));
		job.setRoles(roleRepo.save(roles));
		return jobExperienceRepo.save(job);
	}
	
	

	@Override
	public Map<String, JSONObject> getJob() {
	    Map<String, JSONObject> jsonMap= new HashMap<>();
	    Map<String,List<JSONObject>> roleMap = new HashMap<>();
	    Map<String,Period> PeriodMap = new HashMap<>();


	    List<JobExperience> jobList = jobExperienceRepo.findAll();

	    for (JobExperience job : jobList) {
	        List<JSONObject> roleJsonList = new ArrayList<JSONObject>();
	        JSONObject roleJson = new JSONObject();
	        JSONObject jobJson = new JSONObject();
	        

	        if (!roleMap.containsKey(job.getCompanyName())) {
	            roleJson.put("role", job.getRoles().getRole());
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
	            String month = job.getRoles().getStartDate().format(formatter);
		        roleJson.put("startDate", month+" "+job.getRoles().getStartDate().getYear());
		         month = job.getRoles().getEndDate().format(formatter);
		        roleJson.put("endDate",month+" "+job.getRoles().getEndDate().getYear());
		        String period =calculatePeriod(job.getRoles().getStartDate(),job.getRoles().getEndDate());
		        roleJson.put("period", period);
		        roleJson.put("city", job.getRoles().getCity());
		        roleJson.put("state", job.getRoles().getState());
		        roleJsonList.add(roleJson);
		        
	            jobJson.put("company", job.getCompanyName());
	            jobJson.put("img", job.getImg());
	            PeriodMap.put(job.getCompanyName(), Period.between(job.getRoles().getStartDate(), job.getRoles().getEndDate()));
	            jobJson.put("jobType", getJobType(PeriodMap.get(job.getCompanyName())));
		        String totalPeriod = getTotalPeriod(PeriodMap.get(job.getCompanyName()));
		        jobJson.put("totalPeriod", totalPeriod);
	            jobJson.put("roles", roleJsonList);
	            jsonMap.put(job.getCompanyName(), jobJson);
	            roleMap.put(job.getCompanyName(), roleJsonList);
	        } else {
	        	JSONObject j=jsonMap.get(job.getCompanyName());
	        	roleJson.put("role", job.getRoles().getRole());
	        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
	            String month = job.getRoles().getStartDate().format(formatter);
		        roleJson.put("startDate",  month+" "+job.getRoles().getStartDate().getYear());
		        month = job.getRoles().getEndDate().format(formatter);
		        roleJson.put("endDate", month+" "+job.getRoles().getEndDate().getYear());
		        roleJson.put("period",calculatePeriod(job.getRoles().getStartDate(),job.getRoles().getEndDate()));
		        roleJson.put("city", job.getRoles().getCity());
		        roleJson.put("state", job.getRoles().getState());
		        roleJsonList= roleMap.get(job.getCompanyName());
		        roleJsonList.add(roleJson);
		        j.put("roles", roleJsonList);
		        PeriodMap.put(job.getCompanyName(),PeriodMap.get(job.getCompanyName()).plus(Period.between(job.getRoles().getStartDate(), job.getRoles().getEndDate())));
	            j.put("jobType", getJobType(PeriodMap.get(job.getCompanyName())));
		        String totalPeriod = getTotalPeriod(PeriodMap.get(job.getCompanyName()));
		        j.put("totalPeriod", totalPeriod);
	            roleMap.put(job.getCompanyName(), roleJsonList);
	            
	        }
	        
	    }
	    return jsonMap;
	}
	
	
	public  String calculatePeriod(LocalDate startDate, LocalDate endDate) {
	    Period period = Period.between(startDate, endDate);
	    int years = period.getYears();
	    int months = period.getMonths();
	    StringBuilder result = new StringBuilder();
	    if (years > 0) {
	        result.append(years).append(years > 1 ? " yrs " : " yr ");
	    }
	    if (months > 0) {
	        result.append(months).append(months > 1 ? " mos" : " mo");
	    }
	    return result.toString().trim();
	}
		    
	public  String getTotalPeriod(Period period) {
        int totalMonths =(int) period.toTotalMonths();
        int years = totalMonths / 12;
        int months = totalMonths % 12;
        return years + " yr " + months + " mos";
    }
	
	public  String getJobType(Period period) {
        int totalMonths =(int) period.toTotalMonths();
        if (totalMonths >= 12) {
            return "Full-time";
        } else {
            return "Part-time";
        }
    }




}
