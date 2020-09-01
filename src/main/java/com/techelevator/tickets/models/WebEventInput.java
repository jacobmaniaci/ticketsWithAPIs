package com.techelevator.tickets.models;

import java.time.LocalDate;
import java.util.Date;

public class WebEventInput {
	
	private String name;
	private LocalDate eventDate;



	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getEventDate() {
		return this.eventDate;
	}
	
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

}


