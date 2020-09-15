package com.techelevator.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tickets.data.BuyerDAO;
import com.techelevator.tickets.data.EventDAO;
import com.techelevator.tickets.data.RowDAO;
import com.techelevator.tickets.data.SeatDAO;
import com.techelevator.tickets.data.SectionDAO;
import com.techelevator.tickets.data.TicketsDAO;
import com.techelevator.tickets.models.Buyer;
import com.techelevator.tickets.models.Event;
import com.techelevator.tickets.models.EventAdmin;
import com.techelevator.tickets.models.Section;
import com.techelevator.tickets.models.WebEventInput;

@RestController
public class TicketsApplicationController {
	
	@Autowired
	TicketsDAO ticketsDAO;
	@Autowired
	BuyerDAO buyerDAO;
	@Autowired
	EventDAO eventDAO;
	@Autowired
	RowDAO rowDAO;
	@Autowired
	SeatDAO seatDAO;
	@Autowired
	SectionDAO sectionDAO;
	
	@RequestMapping(path="/buyer", method = RequestMethod.POST)
	public void createBuyer(@RequestBody Buyer buyer) {
		buyerDAO.createBuyer(buyer);
	}
	
	@RequestMapping(path="/buyer", method = RequestMethod.GET)
	public List<Buyer> getAllBuyers() {
		List<Buyer> output = buyerDAO.getAllBuyers();
		return output;
	}
	
	@RequestMapping(path="/buyer/{id}", method = RequestMethod.GET)
	public Buyer getBuyer(@PathVariable int id) {
		Buyer output = buyerDAO.getBuyer(id);
		return output;
	}
	
	@RequestMapping(path="/buyer/{id}", method = RequestMethod.DELETE)
	public void deleteBuyer(@PathVariable int id) {
		buyerDAO.deleteBuyer(id);
	}
	
	@RequestMapping(path="/buyer/{id}", method = RequestMethod.PUT)
	public void updateBuyer(@RequestBody Buyer buyer, @PathVariable int id) {
		buyerDAO.updateBuyer(buyer, id);
	}
	
	@RequestMapping(path="/event", method = RequestMethod.POST)
	public void createEvent(@RequestBody WebEventInput event) {
		// JSON form for event is "yyyy-mm-dd"
		eventDAO.createEvent(event.getName(), event.getEventDate());
	}
	
	@RequestMapping(path="/event", method = RequestMethod.GET)
	public List<String> getAllEvents() {
		List<String> output = eventDAO.getAllEvents();
		return output;
	}
	
	@RequestMapping(path="/event/{id}", method = RequestMethod.GET)
	public Event getEvent(@PathVariable int id) {
		Event output = eventDAO.getEvent(id);
		return output;
	}
	
	@RequestMapping(path="/event/{id}", method = RequestMethod.PUT)
	public void updateEvent(@RequestBody Event event, @PathVariable int id) {
		eventDAO.updateEvent(event, id);
	}
	
	@RequestMapping(path="/event/{eventName}/section", method = RequestMethod.GET)
	public List<String> getAllSections(@PathVariable String eventName) {
		List<String> output = sectionDAO.getAllSections(eventName);
		return output;
	}

}
