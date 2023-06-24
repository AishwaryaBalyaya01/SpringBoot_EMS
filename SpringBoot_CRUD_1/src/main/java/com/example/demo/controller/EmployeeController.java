package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.*;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping()
	public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();
	}
}
