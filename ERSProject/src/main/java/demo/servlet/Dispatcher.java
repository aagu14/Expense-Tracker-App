package demo.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.controller.EmployeesController;
import demo.controller.LoginController;
import demo.controller.LoginParams;
import demo.controller.TicketsController;


public class Dispatcher {

	public static void MotherRussia(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("The current URI is: " + req.getRequestURI());

		switch (req.getRequestURI()) {

		case "/ERSProject/clown/admin/get-emps":
			System.out.println("case 1");
			EmployeesController.getAllEmps(req, resp);
			break;
		case "/ERSProject/clown/admin/get-tickets":
			System.out.println("case 2");
			TicketsController.getAllTickets(req, resp);
			break;

		case "/ERSProject/clown/add-emp":
			System.out.println("case3");
			EmployeesController.addEmployee(req, resp);
			break;
		case "/ERSProject/clown/approve":
			System.out.println("case 7");
			TicketsController.acceptTicket(req, resp);
			break;
		case "/ERSProject/clown/deny":
			System.out.println("case 9");
			TicketsController.denyTicket(req, resp);
			break;
		
			
		case "/ERSProject/clown/login/add-ticket":
			System.out.println("case 4");
			TicketsController.addTicket(req, resp);
			break;

		case "/ERSProject/clown/login":
			System.out.println("case 5");
			LoginController.loginDirectResponseJson(req, resp);
			break;

		case "/ERSProject/clown/login/current":
			System.out.println("case 6");
			LoginController.checkCurrentUser(req, resp);
			break;


		case "/ERSProject/clown/login/logout":
			System.out.println("case 8");
			LoginController.logout(req, resp);
			break;
			
		case "/ERSProject/clown/loginparams":
			System.out.println("case 10");
			LoginParams.loginParams(req, resp);
			break;

		default:
			System.out.println("Wasted");
			break;
		}
	}

}
