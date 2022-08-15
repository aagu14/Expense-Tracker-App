package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.model.Employees;
import demo.service.EmployeesService;
import demo.service.EmployeesServiceInterface;

public class EmployeesController {

	public static void getAllEmps(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//create instance of the empServ
		EmployeesServiceInterface myServ = new EmployeesService();
		
		//calls method getAllEmps() and assigns it to a variable
		List<Employees> myList = myServ.getAllEmployees();
		
		//convert the list to a json
		resp.setContentType("application/json");
		String myJson = new ObjectMapper().writeValueAsString(myList);
		
		PrintWriter printer = resp.getWriter();
		printer.println(myJson);
		
		}
	
	
	public static void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        EmployeesServiceInterface myServ = new EmployeesService();

        ObjectMapper mapper = new ObjectMapper();

        Employees newEmployee = mapper.readValue(req.getInputStream(), Employees.class);
        myServ.addEmployee(newEmployee);
        System.out.println(newEmployee);

        resp.setContentType("application/json");
        PrintWriter printer = resp.getWriter();
        printer.write(new ObjectMapper().writeValueAsString(newEmployee));
    }
}
