package demo.service;

import java.util.List;

import demo.model.Employees;

public interface EmployeesServiceInterface {

	public List<Employees> getAllEmployees();

	boolean addEmployee(Employees employee);

	Employees getEmpUsername(String emp_username);
	
	

}
