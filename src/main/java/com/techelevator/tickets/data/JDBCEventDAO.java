package com.techelevator.tickets.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Event;

@Component
public class JDBCEventDAO implements EventDAO {

	private JdbcTemplate template;
	private JDBCSectionDAO sectionDAO;

	public JDBCEventDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		sectionDAO = new JDBCSectionDAO(dataSource);
	}
 
	@Override
	public void createEvent(Event event) {
		String sql = "INSERT INTO event (event_name, event_date) VALUES (?, ?)";
		String eventName = event.getEventName();
		Date eventDate = event.getEventDate();
		
		template.update(sql, eventName, eventDate);
	}

	@SuppressWarnings("null")
	@Override
	public List<Event> getAllEvents() {
		String sql = "SELECT * FROM event";
		List<Event> output = new ArrayList<>();
		SqlRowSet results = template.queryForRowSet(sql);
		
		while (results.next()) {
			int id = results.getInt("event_id");
			String eventName = results.getString("event_name");
			Date eventDate = results.getDate("event_date");
			
			Event event = new Event(id, eventName, (java.sql.Date) eventDate);
			output.add(event);
		}
		return output;
	}

	@Override
	public Event getEvent(int id) {
		String sql = "SELECT * FROM event WHERE event_id = ?";
		Event output = null;
		SqlRowSet results = template.queryForRowSet(sql, id);
		
		while(results.next()) {
			String eventName = results.getString("event_name");
			Date eventDate = results.getDate("event_date");
			
			output = new Event(id, eventName, (java.sql.Date) eventDate);
		}
		return output;
	}

	@Override
	public void updateEvent(Event event, int id) {
		String sql = "UPDATE event SET event_name = ?, event_date = ? WHERE event_id = ?";
		String eventName = event.getEventName();
		Date eventDate = event.getEventDate();
		
		template.update(sql, eventName, eventDate, id);

	}

	@Override
	public void deleteEvent(int id) {
		String sql = "DELETE FROM event WHERE event_id = ?";
		template.update(sql, id);
	}

}
