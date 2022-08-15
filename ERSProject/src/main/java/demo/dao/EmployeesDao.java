package demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.model.Employees;
import demo.model.Tickets;

public class EmployeesDao implements EmployeesDaoInterface {

@Override
public List<Employees> selectAllEmps() {
	 	List<Employees> emps = new ArrayList<>();
			
		try(Connection conn = ConnectionFactory.getConnection()) {	
				
				String selectFrom = "Select * From Employees";
				
				PreparedStatement ps = conn.prepareStatement(selectFrom);
				
				ResultSet resultSet = ps.executeQuery();
				
				while(resultSet.next()) {
					Employees newEmployee = new Employees(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)
																			 , resultSet.getString(4), resultSet.getString(5));
					
					
					emps.add(newEmployee);
					
				}
				
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
			return emps;
	}

@Override
public Employees selectEmpUsername(String emp_username) {
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		String selectUser = "SELECT * FROM employees WHERE emp_username =?";
		
		PreparedStatement ps = conn.prepareStatement(selectUser);
		ps.setString(1, emp_username);
		
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			
			Employees newEmp = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3)
													, rs.getString(4), rs.getString(5));
			
			return newEmp;
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} return null; 
}

@Override 
public boolean insertEmployee(Employees employee) {
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		String insert = "INSERT INTO employees VALUES (?,?,'employee',?,?)";
		
		PreparedStatement ps = conn.prepareStatement(insert);
		
		ps.setInt(1, employee.getEmp_id());
		ps.setString(2, employee.getFullName());
		ps.setString(3, employee.getEmp_username());
		ps.setString(4, employee.getEmp_password());
		ps.executeUpdate();
		
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

public static void main(String[] args) {
	EmployeesDao myDao = new EmployeesDao();
			
			System.out.println(myDao.selectEmpUsername("aayush218"));;;
	
}

}
