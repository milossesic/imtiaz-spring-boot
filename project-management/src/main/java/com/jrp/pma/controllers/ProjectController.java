package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@GetMapping
	public String displayProjects(Model model, Project project) {
		
		List<Project> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);
		
		return "projects/list-projects";
		
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project",aProject);
		
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		
		projectRepo.save(project);
		
		return "redirect:/projects/new";
		
	}

}
