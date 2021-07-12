package com.tvm.ems.service;

import com.tvm.ems.dto.EmployeeDto;
import com.tvm.ems.model.Employee;

public interface EmployeeService {
	Employee getByEmail(String email);
	Employee saveEmployee(Employee employee);
	boolean validateEmployee(EmployeeDto employeeDto);
	String returnStaement(String email);
	boolean emailIsPresent(String email);
}
