package com.demo.pmc.spring.aop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
		
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public List<Employee> getEmployeeById(@PathVariable int id){
		return employeeService.getEmployee();
	}
	
	
	
}
