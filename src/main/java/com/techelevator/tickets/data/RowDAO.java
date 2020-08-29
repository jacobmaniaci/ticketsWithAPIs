package com.techelevator.tickets.data;

import java.util.List;

import com.techelevator.tickets.models.Row;

public interface RowDAO {
	public void createRow(Row row);
	public List<Row> getAllRows();
	public Row getRow(int id);
	public void updateRow(Row row);
	public void deleteRow(int id);
}
