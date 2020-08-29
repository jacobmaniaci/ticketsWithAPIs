package com.techelevator.tickets.data;

import java.util.List;

import com.techelevator.tickets.models.Event;

public interface EventDAO {

	public void createEvent(Event event);
	public List<Event> getAllEvents();
	public Event getEvent(int id);
	public void updateEvent(Event event);
	public void deleteEvent(int id);
	
}
