package com.techelevator.tickets.models;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class Event {
	
	private int eventId;
	@NotBlank(message = "Event Must Have a Name")
	private String eventName;
	@NotBlank(message = "Event Must Have a Date")
	private Date eventDate;
	
	public Event(int eventId, String eventName, Date eventDate) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

}
