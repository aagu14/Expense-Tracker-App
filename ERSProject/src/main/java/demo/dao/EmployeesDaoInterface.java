package demo.dao;

import java.util.List;

import demo.model.Employees;

public interface EmployeesDaoInterface {
	public List<Employees> selectAllEmps();

	Employees selectEmpUsername(String emp_username);

	boolean insertEmployee(Employees employee);
}
