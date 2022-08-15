package demo.service;

import java.util.List;

import demo.model.Tickets;

public interface TicketsServiceInterface {

	List<Tickets> getAllTickets();

	boolean addTicket(Tickets ticket);

	boolean updateTicket(int ticket_id);

	boolean rejectStatus(int ticket_id);
}
