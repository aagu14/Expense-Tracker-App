package demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.model.Tickets;

public class TicketsDao implements TicketsDaoInterface{
	

//	public static void main(String[] args) {
//		TicketsDao myDao = new TicketsDao();
//		System.out.println();
//	}

@Override
public List<Tickets> selectallTickets() {	
	
	List<Tickets> myTickets = new ArrayList<>();
		
	String join = "SELECT * FROM tickets";

	try (Connection conn = ConnectionFactory.getConnection()) {
		
		PreparedStatement ps = conn.prepareStatement(join);
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) {
			Tickets newTicket = new Tickets(
					resultSet.getInt(1),
					resultSet.getInt(2),
					resultSet.getString(3),
					resultSet.getString(4),
					resultSet.getInt(5));
					
			myTickets.add(newTicket);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} return myTickets;
		
}

@Override
public boolean insertTicket(Tickets ticket) {
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		String insert = "INSERT INTO tickets VALUES (?,?,?,'pending', ?)";
		
		PreparedStatement ps = conn.prepareStatement(insert);
		
		ps.setInt(1, ticket.getTicket_id());
		ps.setInt(2, ticket.getAmount());
		ps.setString(3, ticket.getDescription());
		ps.setInt(4, ticket.getTicket_emp_id());
		ps.executeUpdate();
		
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}

@Override
public boolean updateStatus(int ticket_id) {
	
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		String update = "UPDATE tickets SET status = 'approved' where ticket_id =?";
		
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, ticket_id); //first ?
		ps.executeUpdate();
		
		return true;
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
	
}

@Override
public boolean banWorld(int ticket_id) {
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		String ban = "UPDATE tickets SET status = 'denied' where ticket_id =?";
		
		PreparedStatement ps = conn.prepareStatement(ban);
		ps.setInt(1, ticket_id); 
		ps.executeUpdate();
		
		return true;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
	
	
}

public static void main(String[] args) {

	TicketsDao myDao = new TicketsDao();
	
 //  myDao.insertTicket(new Tickets(8, 9000, "vacation", "pending", 8));
	//myDao.updateStatus(3);
	myDao.banWorld(3); 
	//System.out.println(myDao.selectallTickets());
}



}
