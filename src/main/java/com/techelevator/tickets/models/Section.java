package com.techelevator.tickets.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class Section {
	
	private int sectionId;
	@NotBlank(message = "Must Provide a Section to Search")
	private String sectionName;
	private BigDecimal sectionPrice;
//	private int eventId;
	
	public Section(int sectionId, String sectionName, BigDecimal sectionPrice) {
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.sectionPrice = sectionPrice;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public BigDecimal getSectionPrice() {
		return sectionPrice;
	}

	public void setSectionPrice(BigDecimal sectionPrice) {
		this.sectionPrice = sectionPrice;
	}
	
}
