package com.techelevator.tickets.data;

import java.util.List;

import com.techelevator.tickets.models.Ticket;

public interface TicketsDAO {
	
	public void createTicket(Ticket ticket);
	public List<Ticket> getAllTickets();
	public Ticket getTicket(int id);
	public void updateTicket(Ticket ticket);
	public void deleteTicket(int id);

}
