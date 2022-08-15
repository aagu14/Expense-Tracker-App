package demo.service;

import java.util.List;

import demo.dao.TicketsDao;
import demo.dao.TicketsDaoInterface;
import demo.model.Tickets;

public class TicketsService implements TicketsServiceInterface {
	
	TicketsDaoInterface myDao = new TicketsDao();


public List <Tickets> getAllTickets() {
	
	return myDao.selectallTickets();
}



public boolean addTicket(Tickets ticket) {
	return myDao.insertTicket(ticket);
}


@Override 
public boolean updateTicket(int ticket_id) {
	return myDao.updateStatus(ticket_id);
}

@Override
public boolean rejectStatus(int ticket_id) {
	return myDao.banWorld(ticket_id);
	
}


}