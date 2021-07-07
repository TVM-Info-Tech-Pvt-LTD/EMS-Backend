package com.tvm.ems.model;

import java.sql.Date;

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
 private String employeeGender;
 private Date employeeDOB;
 private long employeePhoneNumber;
 private String employeeAddress;
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
public String getEmployeeGender() {
	return employeeGender;
}
public void setEmployeeGender(String employeeGender) {
	this.employeeGender = employeeGender;
}
public Date getEmployeeDOB() {
	return employeeDOB;
}
public void setEmployeeDOB(Date employeeDOB) {
	this.employeeDOB = employeeDOB;
}
public long getEmployeePhoneNumber() {
	return employeePhoneNumber;
}
public void setEmployeePhoneNumber(long employeePhoneNumber) {
	this.employeePhoneNumber = employeePhoneNumber;
}
public String getEmployeeAddress() {
	return employeeAddress;
}
public void setEmployeeAddress(String employeeAddress) {
	this.employeeAddress = employeeAddress;
}
}
