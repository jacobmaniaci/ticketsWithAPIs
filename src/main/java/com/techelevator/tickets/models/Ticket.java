package com.techelevator.tickets.models;


import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class Ticket {
	
	private int ticketId;
//	private int eventId;
//	private int sectionId;
//	private int rowId;
//	private int seatId;
//	private int buyerId;
	private boolean purchased;
	@NotBlank(message = "Must Have a Purchase Timestamp")
	private LocalDate ticketDate;
	
	public Ticket(int ticketId, boolean purchased, LocalDate ticketDate) {
		this.ticketId = ticketId;
		this.purchased = purchased;
		this.ticketDate = ticketDate;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

	public LocalDate getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
	}
	
}
