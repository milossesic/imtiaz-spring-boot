package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository <Project, Long> {
	
	@Override
	public List<Project> findAll();
	
	//fields are label, value
	@Query(nativeQuery=true,value="SELECT p.stage AS label, COUNT (*) AS value " + 
			"FROM project p GROUP BY p.stage;")
	public List<ChartData> getProjectStatus();

}
