package com.techelevator.tickets.data;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Ticket;

@Component
public class JDBCTicketDAO implements TicketsDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCTicketDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public void createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket getTicket(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTicket(int id) {
		// TODO Auto-generated method stub
		
	}
}
