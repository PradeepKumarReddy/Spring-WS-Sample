//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.05 at 07:12:58 PM IST 
//


package com.sample.webservices.employeeservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sample.webservices.employeeservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sample.webservices.employeeservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmployeeDetailsResponse }
     * 
     */
    public EmployeeDetailsResponse createEmployeeDetailsResponse() {
        return new EmployeeDetailsResponse();
    }

    /**
     * Create an instance of {@link EmployeesListResponse }
     * 
     */
    public EmployeesListResponse createEmployeesListResponse() {
        return new EmployeesListResponse();
    }

    /**
     * Create an instance of {@link EmployeeDetailsRequest }
     * 
     */
    public EmployeeDetailsRequest createEmployeeDetailsRequest() {
        return new EmployeeDetailsRequest();
    }

    /**
     * Create an instance of {@link EmployeesListRequest }
     * 
     */
    public EmployeesListRequest createEmployeesListRequest() {
        return new EmployeesListRequest();
    }

}
