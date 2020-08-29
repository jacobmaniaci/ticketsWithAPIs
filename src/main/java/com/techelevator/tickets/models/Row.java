package com.techelevator.tickets.models;

import javax.validation.constraints.NotBlank;

public class Row {

	private int rowId;
	@NotBlank(message = "Row Must Have a Name")
	private String rowName;
//	private int sectionId;
	
	public Row(int rowId, String rowName) {
		this.rowId = rowId;
		this.rowName = rowName;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}
	
}
