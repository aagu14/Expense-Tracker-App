package demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.model.Employees;
import demo.service.EmployeesService;
import demo.service.EmployeesServiceInterface;

public class LoginParams {
	public static void loginParams(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
				
				EmployeesServiceInterface employee = new EmployeesService();
				
				
				String attemptedUsername = req.getParameter("Username");
		        String attemptedPassword = req.getParameter("Password");
		        System.out.println("Using query params from the user");
		        Employees actualUser = employee.getEmpUsername(attemptedUsername);
		        /*
		         * Here we'll go to the database and find out if the user object they are trying
		         * access exists at all.
		         * 
		         * UserAccount actualUser = serviceLayerObject.selectUserByUsername(attemptedUsername);
		         */
		        //UserAccount actualUser = new UserAccount(-1, "mac", "cheese", "admin");
		        String actualUsername = actualUser.getEmp_username(); //you got this from the database, you didn't hardcode
		        String actualPassword = actualUser.getEmp_password();


		        /*
		         * HERE we are checking to see if the user has the correct username & password
		         * 
		         * IN REALITY, you'll go to the database to get the username & password
		         * you won't hardcode them here. A simple strategy is to use the username
		         * they typed in to go to the database and retrieve the user object for that
		         * given username they typed in; THEN once you have the user object in Java
		         * check to see if the typed in password matches the password from the database.
		         * If they match then log them in, if not tell them they screwed up.
		         * OR
		         * select * from usertable where username=x and password=y;
			*/
				 
				if(attemptedUsername.equals(actualUsername) && attemptedPassword.equals(actualPassword)) {
					//they successfully logged in
					System.out.println(actualUser);
					req.getSession().setAttribute("currentUser", actualUser);
					resp.getWriter().println("You successfully logged in, "+ actualUsername);
				}else {
					//else they DIDN'T successfully log in
					resp.getWriter().println("You won't bamboosle me today!");
				}
			}

}
