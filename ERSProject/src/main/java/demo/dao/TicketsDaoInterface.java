package demo.dao;

import java.util.List;

import demo.model.Tickets;

public interface TicketsDaoInterface {

	public List<Tickets> selectallTickets();

	boolean insertTicket(Tickets ticket);

	boolean updateStatus(int ticket_id);

	boolean banWorld(int ticket_id);
	
	//public boolean insertTicket(Tickets ticket) {
}
	
	

