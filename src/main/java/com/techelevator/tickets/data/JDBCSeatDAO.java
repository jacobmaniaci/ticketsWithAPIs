package com.techelevator.tickets.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Seat;

@Component
public class JDBCSeatDAO implements SeatDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSeatDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createSeat(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seat> getAllSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seat getSeat(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSeat(int id) {
		// TODO Auto-generated method stub
		
	}

}
