package com.sample.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.sample.webservices.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public Employee getEmployeeDetails(String empId) {
		Employee employee = new Employee();
		employee.setEmpId(Integer.parseInt(empId));
		employee.setEmployeeName("Emp" + empId);
		employee.setDOB(getGregorianCalender());
		return employee;
	}
	
	public XMLGregorianCalendar getGregorianCalender() {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return xgcal;
	}

	public List<Employee> getEmployeeList() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee1 = new Employee();
		employee1.setEmpId(1);
		employee1.setEmployeeName("Emp" + 1);
		employee1.setDOB(getGregorianCalender());
		
		Employee employee2 = new Employee();
		employee2.setEmpId(2);
		employee2.setEmployeeName("Emp" + 2);
		employee2.setDOB(getGregorianCalender());
		
		Employee employee3 = new Employee();
		employee3.setEmpId(3);
		employee3.setEmployeeName("Emp" + 3);
		employee3.setDOB(getGregorianCalender());
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
		return employees;
	}
	
	public String saveEmployess(List<Employee> employees) throws Exception {
		System.out.println(Arrays.toString(employees.toArray()));
		return null;
	}

}
