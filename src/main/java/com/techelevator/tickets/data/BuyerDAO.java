package com.techelevator.tickets.data;

import java.util.List;

import com.techelevator.tickets.models.Buyer;

public interface BuyerDAO {
	
	public void createBuyer(Buyer buyer);
	public List<Buyer> getAllBuyers();
	public Buyer getBuyer(int id);
	public void updateBuyer(Buyer buyer, int id);
	public void deleteBuyer(int id);

}
