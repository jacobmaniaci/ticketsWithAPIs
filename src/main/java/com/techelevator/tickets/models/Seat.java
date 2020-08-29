package com.techelevator.tickets.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Seat {
	
	private int seatId;
	@Min(value=1, message = "Seats Range From 1 to 40")
	@Max(value=40, message = "Seats Range From 1 to 40")
	private int seatNumber;
//	private int rowId;
	
	public Seat(int seatId, int seatNumber) {
		this.seatId = seatId;
		this.seatNumber = seatNumber;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

}
