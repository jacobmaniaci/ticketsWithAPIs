package com.techelevator.tickets.models;

import javax.validation.constraints.NotBlank;

public class Buyer {
	
	private int buyerId;
	@NotBlank(message = "Must Provide a First Name")
	private String firstName;
	@NotBlank(message = "Must Provide a Last Name")
	private String lastName;
	
	public Buyer(int buyerId, String firstName, String lastName) {
		this.buyerId = buyerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
