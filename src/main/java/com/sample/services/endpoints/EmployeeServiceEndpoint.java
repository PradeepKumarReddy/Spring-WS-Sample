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
import com.sample.webservices.employeeservice.SaveEmployeesRequest;
import com.sample.webservices.employeeservice.SaveEmployeesResponse;

/**
 * The Class EmployeeService.
 */
@Endpoint
public class EmployeeServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://com/sample/webservices/employeeservice";

	@Autowired
	private EmployeeService employeeService;

	// http://localhost:8098/Spring-WS-Sample/endpoints/EmployeeDetailsService.wsdl
	// this localPart (EmployeeDetailsRequest) should get match with input
	// request name (@RequestPayload EmployeeDetailsRequest )
	@PayloadRoot(localPart = "EmployeeDetailsRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload
	EmployeeDetailsResponse getEmployeeDetails(
			@RequestPayload EmployeeDetailsRequest request) {
		EmployeeDetailsResponse response = new EmployeeDetailsResponse();

		/* call Spring injected service implementation to retrieve account data */
		Employee employee = employeeService.getEmployeeDetails(request
				.getEmpId());
		response.setEmployeeDetails(employee);
		return response;
	}

	@PayloadRoot(localPart = "EmployeesListRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload
	EmployeesListResponse getEmployeeList(
			@RequestPayload EmployeesListRequest request) {
		EmployeesListResponse response = new EmployeesListResponse();

		/* call Spring injected service implementation to retrieve account data */
		List<Employee> employees = employeeService.getEmployeeList();
		response.getEmployees().addAll(employees);
		return response;
	}

	
	/**
	 * 
	 * @param request
	 * @return
	 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:emp="http://com/sample/webservices/employeeservice" xmlns:web="http://webservices.sample.com"
		xmlns:ns2="http://webservices.sample.com">
      <soapenv:Header>
		      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">
		         <wsu:Timestamp wsu:Id="Timestamp-1" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
		            <wsu:Created>2015-11-07T12:43:52.920Z</wsu:Created>
		            <wsu:Expires>2015-12-07T12:44:52.920Z</wsu:Expires>
		         </wsu:Timestamp>
		         <wsse:UsernameToken xmlns:wsu="...">
		            <wsse:Username>admin</wsse:Username>
		            <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">secret</wsse:Password>
		         </wsse:UsernameToken>
		      </wsse:Security>
		   </soapenv:Header>
   <soapenv:Body>
      <emp:SaveEmployeesRequest>
         <!--Zero or more repetitions:-->
          <emp:Employees>
            <ns2:EmpId>123456</ns2:EmpId>
            <ns2:EmployeeName>Emp21</ns2:EmployeeName>
            <ns2:DOB>2015-11-06+05:30</ns2:DOB>
         </emp:Employees>
         <emp:Employees>
            <ns2:EmpId>234566</ns2:EmpId>
            <ns2:EmployeeName>Emp22</ns2:EmployeeName>
            <ns2:DOB>2015-11-06+05:30</ns2:DOB>
         </emp:Employees>
         <emp:Employees>
            <ns2:EmpId>345675</ns2:EmpId>
            <ns2:EmployeeName>Emp32</ns2:EmployeeName>
            <ns2:DOB>2015-11-06+05:30</ns2:DOB>
         </emp:Employees>
      </emp:SaveEmployeesRequest>
   </soapenv:Body>
</soapenv:Envelope>
	 */
	@PayloadRoot(localPart = "SaveEmployeesRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload SaveEmployeesResponse saveEmployees(@RequestPayload SaveEmployeesRequest request)
	{
		SaveEmployeesResponse response = new SaveEmployeesResponse();

		//call Spring injected service implementation to retrieve account data 
		try {
			List<Employee> employees = request.getEmployees();
			employeeService.saveEmployess(employees);
			response.setMessage("Saved Employees Successfully");
		} catch (Exception e) {
			response.setMessage(e.getMessage());
		}
		
		return response;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}