package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.*;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//add CRUD database methods
}