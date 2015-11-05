package com.sample.services.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sample.services.EmployeeService;
import com.sample.webservices.Employee;
import com.sample.webservices.employeeservice.EmployeeDetailsRequest;
import com.sample.webservices.employeeservice.EmployeeDetailsResponse;
import com.sample.webservices.employeeservice.EmployeeListRequest;
import com.sample.webservices.employeeservice.EmployeesListRequest;
import com.sample.webservices.employeeservice.EmployeesListResponse;

/**
 * The Class EmployeeService.
 */
@Endpoint
public class EmployeeServiceEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/sample/webservices/employeeservice";

	@Autowired
	private EmployeeService employeeService;

	//http://localhost:8098/Spring-WS-Sample/endpoints/EmployeeDetailsService.wsdl
	// this localPart (EmployeeDetailsRequest) should get match with input request name (@RequestPayload EmployeeDetailsRequest )
	@PayloadRoot(localPart = "EmployeeDetailsRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload EmployeeDetailsResponse getEmployeeDetails(@RequestPayload EmployeeDetailsRequest request)
	{
		EmployeeDetailsResponse response = new EmployeeDetailsResponse();

		/* call Spring injected service implementation to retrieve account data */
		Employee employee = employeeService.getEmployeeDetails(request.getEmpId());
		response.setEmployeeDetails(employee);
		return response;
	}
	
	@PayloadRoot(localPart = "EmployeesListRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload EmployeesListResponse getEmployeeList(@RequestPayload EmployeesListRequest request)
	{
		EmployeesListResponse response = new EmployeesListResponse();

		/* call Spring injected service implementation to retrieve account data */
		List<Employee> employees = employeeService.getEmployeeList();
		response.getEmployees().addAll(employees);
		return response;
	}
	

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}