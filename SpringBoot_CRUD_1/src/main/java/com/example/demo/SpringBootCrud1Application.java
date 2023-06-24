package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootCrud1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrud1Application.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setFirstName("Aishwarya");
		emp.setLastName("Balyaya");
		emp.setEmailId("bal.a@gmail.com");
		employeeRepository.save(emp);
		
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Ashna");
		emp1.setLastName("Men");
		emp1.setEmailId("ashna.a@gmail.com");
		employeeRepository.save(emp1);
	}

}
