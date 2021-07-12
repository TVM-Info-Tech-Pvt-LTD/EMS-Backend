package com.tvm.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tvm.ems.dto.EmployeeDto;
import com.tvm.ems.dto.ForgotDto;
import com.tvm.ems.model.Employee;
import com.tvm.ems.service.EmployeeService;
import com.tvm.ems.service.ForgotPasswordImpl;
import com.tvm.ems.service.ForgotPasswordService;
@CrossOrigin("http://localhost:4200/")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ForgotPasswordService forgotPasswordService;
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

	   
	   @GetMapping("/employees")
	   public List<Employee> getEmployee()
	   {
		   return employeeService.getEmployee();
	   }
	   

	   @PostMapping("/forgotPassword")
	   public String forgotPassword(@RequestBody EmployeeDto employeeDto) {
		   forgotPasswordService.forgotPassword(employeeDto.getEmployeeEmail());
		   return "Reset password";
		   
	   }
	   @PostMapping("/changePassword")
	   public String changePassword(@RequestBody ForgotDto forgotDto) {
		   forgotPasswordService.changePassword(forgotDto);
		   return "Password reset successfully";
	   }

	}
	
	
	
	
