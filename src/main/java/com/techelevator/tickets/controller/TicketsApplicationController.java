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

@RestController
public class TicketsApplicationController {
	
	@Autowired
	TicketsDAO ticketsDAO;
	BuyerDAO buyerDAO;
	EventDAO eventDAO;
	RowDAO rowDAO;
	SeatDAO seatDAO;
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
	
	@RequestMapping(path="/buyer", method = RequestMethod.PUT)
	public void updateBuyer(@RequestBody Buyer buyer) {
		buyerDAO.updateBuyer(buyer);
	}

}
