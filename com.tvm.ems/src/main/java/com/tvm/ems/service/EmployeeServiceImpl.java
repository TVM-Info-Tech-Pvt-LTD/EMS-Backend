package com.tvm.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.ems.dto.EmployeeDto;
import com.tvm.ems.model.Employee;
import com.tvm.ems.repository.EmployeeRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getByEmail(String email) {
		Employee emp=employeeRepository.findByEmployeeEmail(email);
		return emp;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		if(emailIsPresent(employee.getEmployeeEmail())) {
			Employee emp=employeeRepository.save(employee);
			return emp;
		}
		return null;
	}

	@Override
	public boolean validateEmployee(EmployeeDto employeeDto) {
		Employee emp=getByEmail(employeeDto.getEmployeeEmail());
		if(emp.getEmployeeEmail().equals(employeeDto.getEmployeeEmail())) {
			if(emp.getEmployeePassword().equals(employeeDto.getEmployeePassword())) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String returnStaement(String email) {
		Employee emp=getByEmail(email);
		if(emp.isAdmin()==true) {
			return "Admin Login succesfully";
		}
		return "User login Succesfully";
	}

	@Override
	public boolean emailIsPresent(String email) {
		Employee employee = getByEmail(email);
		if(employee!=null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
	

}
