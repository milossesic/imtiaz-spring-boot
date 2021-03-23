package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	//fields are firstName, lastName, projectCount
	@Query(nativeQuery=true, value="SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) AS projectCount " + 
			"FROM employee e LEFT JOIN project_employee pe " + 
			"ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC;")
	public List<EmployeeProject> employeeProjects();

}
