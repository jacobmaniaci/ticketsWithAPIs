package com.techelevator.tickets.data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.techelevator.tickets.models.Event;
import com.techelevator.tickets.models.EventAdmin;
import com.techelevator.tickets.models.WebEventInput;

public interface EventDAO {

	public void createEvent(String eventName, LocalDate eventDate);
	public List<EventAdmin> getAllEvents();
	public Event getEvent(int id);
	public void updateEvent(Event event, int id);
	public void deleteEvent(int id);
	
}
