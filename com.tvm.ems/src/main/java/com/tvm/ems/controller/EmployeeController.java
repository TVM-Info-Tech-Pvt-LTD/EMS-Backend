package com.tvm.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tvm.ems.dto.EmployeeDto;
import com.tvm.ems.model.Employee;
import com.tvm.ems.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/registration")
	public Employee registrationEmployee(@RequestBody Employee employee) {
		Employee emp=employeeService.saveEmployee(employee);
		return emp;
	}
	String Email;
	@PostMapping("/signin")
	public String siginEmployee(@RequestBody EmployeeDto employeeDto) {
		if(employeeService.validateEmployee(employeeDto)) {
		 Email=employeeDto.getEmployeeEmail();
			//return employeeService.returnStaement(employeeDto.getEmployeeEmail());
		 return success();
		
		}
		
		return " Incorrect Username or Password  ";
	}
	   @PostMapping()
		public String success() {
			
			return employeeService.returnStaement(Email);
		}
		
	}
	
	
	
	
