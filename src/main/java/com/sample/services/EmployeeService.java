package com.sample.services;

import java.util.List;

import com.sample.webservices.Employee;

public interface EmployeeService {

	public Employee getEmployeeDetails(String empId);
	
	public List<Employee> getEmployeeList();
	
	public String saveEmployess(List<Employee> employees) throws Exception;
}
