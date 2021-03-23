package com.jrp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<ChartData> projectData = projectRepo.getProjectStatus();
		//convert projectData object into a JSON structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//[["NOTSTARTED",1],["INPROGRESS",2],["COMPLETED",1]]
		model.addAttribute("projectStatusCount",jsonString);
		
		
		List<EmployeeProject> employeesProjectCount = employeeRepo.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		
		return "main/home";
		
		
	}

}
