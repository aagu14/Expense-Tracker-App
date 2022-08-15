package demo.service;

import java.util.List;

import demo.dao.EmployeesDao;
import demo.dao.EmployeesDaoInterface;
import demo.model.Employees;

public class EmployeesService implements EmployeesServiceInterface {

	EmployeesDaoInterface myDao = new EmployeesDao();

@Override	
	public List <Employees> getAllEmployees() {
			
		return myDao.selectAllEmps();
	}

@Override
	public boolean addEmployee(Employees employee) {
		return myDao.insertEmployee(employee);
	}
@Override	
	public Employees getEmpUsername(String emp_username) {
		return myDao.selectEmpUsername(emp_username);
		
		
	}
	/*
	public static void main(String[] args) {
		EmployeesService myServ = new EmployeesService();
		System.out.println(myServ.getAllEmployees());
		
	}
	*/
}




  