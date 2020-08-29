package com.techelevator.tickets.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Event;

@Component
public class JDBCEventDAO implements EventDAO {

	@Override
	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getEvent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(int id) {
		// TODO Auto-generated method stub
		
	}

}
