package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.model.Employees;

public class LoginController {


	public static void checkCurrentUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Employees sessionUser = (Employees)session.getAttribute("currentUser");
		System.out.println(sessionUser);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();
		
		printer.write(new ObjectMapper().writeValueAsString(sessionUser));
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		
		resp.setContentType("text/html");
		PrintWriter printer = resp.getWriter();
		printer.println("You've successfully logged out");
	}
	
	public static void loginDirectResponseJson(HttpServletRequest req, HttpServletResponse resp) throws IOException {


		/*
		 * SPECIFIC route guarding logic could go here
		 * 
		 * Stuff like:
		 * "check if the user has an admin token in their session"
		 * OR
		 * "check if they are using the correct http method"
		 * OR
		 * something to this effect
		 */
//		UserAccount sessionUser = (UserAccount)req.getSession().getAttribute("currentUser");
		if( ! req.getMethod().equals("POST") ) {
			resp.getWriter().println("You didn't use a POST method; are you tryna hack me?");
			return;
		}
//		else if (sessionUser == null || (!sessionUser.getRole().equals("admin")) ) {
//			resp.getWriter().println("You're not an admin, begone knave!");
//			return;
//		}
		
		

		//let's interpret a JSON from the user
		ObjectMapper mapper = new ObjectMapper();
		
		Employees formInputUserObject = mapper.readValue(req.getInputStream(), Employees.class);
		
		//HERE we'll extract the username and password from the user's form inpu
		String attemptedUsername = formInputUserObject.getEmp_username();
		String attemptedPassword = formInputUserObject.getEmp_password();
		System.out.println("Using a json from the user");
		
		/*
		 * Here we'll go to the database and find out if the user object they are trying
		 * access exists at all.
		 * 
		 * UserAccount actualUser = serviceLayerObject.selectUserByUsername(attemptedUsername);
		 */
		Employees actualUser = new Employees(3, "Trevin Chester", "manager", "trevin123", "barnacles435");
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
	
	public static void loginDirectResponseQueryParams(HttpServletRequest req, HttpServletResponse resp) throws IOException {


		/*
		 * SPECIFIC route guarding logic could go here
		 * 
		 * Stuff like:
		 * "check if the user has an admin token in their session"
		 * OR
		 * "check if they are using the correct http method"
		 * OR
		 * something to this effect
		 */
//		UserAccount sessionUser = (UserAccount)req.getSession().getAttribute("currentUser");
		if( ! req.getMethod().equals("POST") ) {
			resp.getWriter().println("You didn't use a POST method; are you tryna hack me?");
			return;
		}
//		else if (sessionUser == null || (!sessionUser.getRole().equals("admin")) ) {
//			resp.getWriter().println("You're not an admin, begone knave!");
//			return;
//		}
		
		

		//let's interpret query params from the user
		
		//HERE we'll extract the username and password from the user's form input
		String attemptedUsername = req.getParameter("myUsername");
		String attemptedPassword = req.getParameter("myPassword");
		System.out.println("Using query params from the user");
		
		/*
		 * Here we'll go to the database and find out if the user object they are trying
		 * access exists at all.
		 * 
		 * UserAccount actualUser = serviceLayerObject.selectUserByUsername(attemptedUsername);
		 */
		Employees actualUser = new Employees(3, "Trevin Chester", "manager", "trevin123", "barnacles435");
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
	
	public static void loginForwardResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


		/*
		 * SPECIFIC route guarding logic could go here
		 * 
		 * Stuff like:
		 * "check if the user has an admin token in their session"
		 * OR
		 * "check if they are using the correct http method"
		 * OR
		 * something to this effect
		 */
//		UserAccount sessionUser = (UserAccount)req.getSession().getAttribute("currentUser");
		if( ! req.getMethod().equals("POST") ) {
			resp.getWriter().println("You didn't use a POST method; are you tryna hack me?");
			return;
		}
//		else if (sessionUser == null || (!sessionUser.getRole().equals("admin")) ) {
//			resp.getWriter().println("You're not an admin, begone knave!");
//			return;
//		}
		
		

		//let's interpret query params from the user
		
		//HERE we'll extract the username and password from the user's form input
		String attemptedUsername = req.getParameter("theirUsername");
		String attemptedPassword = req.getParameter("theirPassword");
		System.out.println("Using form input from the user");
		
		/*
		 * Here we'll go to the database and find out if the user object they are trying
		 * access exists at all.
		 * 
		 * UserAccount actualUser = serviceLayerObject.selectUserByUsername(attemptedUsername);
		 */
		Employees actualUser = new Employees(3, "Trevin Chester", "manager", "trevin123", "barnacles435");
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
			
			req.getRequestDispatcher("/forwarding/home").forward(req, resp);
		}else {
			//else they DIDN'T successfully log in
			req.getRequestDispatcher("/resources/html/badlogin.html").forward(req, resp);
		}
	}

		
	}

