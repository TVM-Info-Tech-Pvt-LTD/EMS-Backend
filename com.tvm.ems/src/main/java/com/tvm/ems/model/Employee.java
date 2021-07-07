package com.tvm.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
 @Id
 @GeneratedValue(strategy =  GenerationType.IDENTITY)
 private long employeeId;
 private String employeeName;
 @Column(nullable = true)
 private String employeeEmail;
 private String employeePassword;
 private boolean admin;
public long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(long employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getEmployeeEmail() {
	return employeeEmail;
}
public void setEmployeeEmail(String employeeEmail) {
	this.employeeEmail = employeeEmail;
}
public String getEmployeePassword() {
	return employeePassword;
}
public void setEmployeePassword(String employeePassword) {
	this.employeePassword = employeePassword;
}
public boolean isAdmin() {
	return admin;
}
public void setAdmin(boolean admin) {
	this.admin = admin;
}
}
