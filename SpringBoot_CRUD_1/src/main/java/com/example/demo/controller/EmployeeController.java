package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.*;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/EMS")
public class EmployeeController {
	 
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmployee")
	public Employee createAllEmployees(@RequestBody Employee employee){
			return employeeRepository.save(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();
	}
	
	@GetMapping(value="/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doesnt exist with this Id"));
		return	ResponseEntity.ok(employee);
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable long id,@RequestBody Employee updateDetails){
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doesnt exist with this Id"));
		
		updateEmployee.setFirstName(updateDetails.getFirstName());
		updateEmployee.setLastName(updateDetails.getLastName());
		updateEmployee.setEmailId(updateDetails.getFirstName());
		
		employeeRepository.save(updateEmployee);
		
		return	ResponseEntity.ok(updateEmployee);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeDetails(@PathVariable long id){
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doesnt exist with this Id"));
		
		employeeRepository.delete(updateEmployee);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
