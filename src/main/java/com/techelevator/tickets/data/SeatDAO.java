package com.techelevator.tickets.data;

import java.util.List;

import com.techelevator.tickets.models.Seat;

public interface SeatDAO {
	
	public void createSeat(Seat seat);
	public List<Seat> getAllSeats();
	public Seat getSeat(int id);
	public void updateSeat(Seat seat);
	public void deleteSeat(int id);

}
