package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.model.Employees;
import demo.model.Tickets;
import demo.service.EmployeesService;
import demo.service.EmployeesServiceInterface;
import demo.service.TicketsService;
import demo.service.TicketsServiceInterface;

public class TicketsController {

	public static void getAllTickets(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//creates an instance of the empServ
		TicketsServiceInterface myServ = new TicketsService();
		
		//calls the method get getAllEmp() AND saves it to a variable
		List<Tickets> myList = myServ.getAllTickets();
		
		//convert the list to a json
		resp.setContentType("application/json");
		String myJson = new ObjectMapper().writeValueAsString(myList);
		
		
		PrintWriter printer = resp.getWriter();
		printer.println(myJson);
			
	}

	
	public static void acceptTicket (HttpServletRequest req, HttpServletResponse resp) throws IOException{
        TicketsServiceInterface myServ = new TicketsService();
        
        ObjectMapper mapper = new ObjectMapper();
        Tickets approve = mapper.readValue(req.getInputStream(),Tickets.class);
        //myServ.updateTicket(7);
        myServ.updateTicket(approve.getTicket_id());
        System.out.println(approve);
        
        resp.setContentType("application/json");
        PrintWriter printer = resp.getWriter();
        printer.write(new ObjectMapper().writeValueAsString(approve));
	}

	public static void denyTicket (HttpServletRequest req, HttpServletResponse resp) throws IOException{
        TicketsServiceInterface myServ = new TicketsService();
        
        ObjectMapper mapper = new ObjectMapper();
        Tickets deny = mapper.readValue(req.getInputStream(),Tickets.class);
       // myServ.rejectStatus(4);
        myServ.rejectStatus(deny.getTicket_id());
        System.out.println(deny);
        
        resp.setContentType("application/json");
        PrintWriter printer = resp.getWriter();
        printer.write(new ObjectMapper().writeValueAsString(deny));
	}
	
		
	

		public static void addTicket(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		    TicketsServiceInterface myServ = new TicketsService();
		
		    ObjectMapper mapper = new ObjectMapper();
		
		    Tickets newTicket = mapper.readValue(req.getInputStream(), Tickets.class);
		    myServ.addTicket(newTicket);
		    System.out.println(newTicket);
		
		    resp.setContentType("application/json");
		    PrintWriter printer = resp.getWriter();
		    printer.write(new ObjectMapper().writeValueAsString(newTicket));
		}
}