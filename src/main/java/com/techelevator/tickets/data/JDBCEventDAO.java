package com.techelevator.tickets.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Event;
import com.techelevator.tickets.models.EventAdmin;
import com.techelevator.tickets.models.WebEventInput;


@Component
public class JDBCEventDAO implements EventDAO {

	private JdbcTemplate template;

	public JDBCEventDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
 
	@Override
	public void createEvent(String eventName, LocalDate eventDate) {
		
		// String newEvent = eventName;
				String[] sections = { "Club", "First Class", "Mid Venue", "General Admission" };
				String[] rows = { "A", "B", "C", "D", "E" };
				String section = "";
				String row = "";
				int seatNumber = 0;
				BigDecimal price = new BigDecimal(0.00);

//				EventCreate newEvent = new EventCreate();

				for (int i = 0; i < sections.length; i++) {
					if (sections[i].equals("Club")) {
						section = sections[i];
						row = "A";
						for (int k = 1; k <= 40; k++) {
							seatNumber = k;
							price = new BigDecimal(300.00).setScale(2, RoundingMode.HALF_UP);

							String makeEvent = "INSERT INTO available_tickets " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
							template.update(makeEvent, nextTicketId(), eventName, section, row, seatNumber, price, eventDate);

						}
					} else if (sections[i].equals("First Class")) {
						section = sections[i];
						for (int j = 0; j < 3; j++) {
							row = rows[j];
							for (int k = 1; k <= 40; k++) {
								seatNumber = k;
								price = new BigDecimal(200.00).setScale(2, RoundingMode.HALF_UP);

								String makeEvent = "INSERT INTO available_tickets " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
								template.update(makeEvent, nextTicketId(), eventName, section, row, seatNumber, price, eventDate);

							}
						}
					} else if (sections[i].equals("Mid Venue")) {
						section = sections[i];
						for (int j = 0; j < rows.length; j++) {
							row = rows[j];
							for (int k = 1; k <= 40; k++) {
								seatNumber = k;
								price = new BigDecimal(100.00).setScale(2, RoundingMode.HALF_UP);

								String makeEvent = "INSERT INTO available_tickets " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
								template.update(makeEvent, nextTicketId(), eventName, section, row, seatNumber, price, eventDate);

							}
						}
					} else {
						section = "General Admission";
						row = "NA";
						for (int k = 1; k <= 440; k++) {
							seatNumber = k;
							price = new BigDecimal(50.00).setScale(2, RoundingMode.HALF_UP);

							String makeEvent = "INSERT INTO available_tickets " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
							template.update(makeEvent, nextTicketId(), eventName, section, row, seatNumber, price, eventDate);

						}
					}

				}
	}

	@Override
	public List<EventAdmin> getAllEvents() {
		return null;
	}

	@Override
	public Event getEvent(int id) {
		return null;
		
	}

	@Override
	public void updateEvent(Event event, int id) {
		
	}

	@Override
	public void deleteEvent(int id) {
		
	}
	
	private EventAdmin mapRowToTicket(SqlRowSet results) {
		EventAdmin ticket = new EventAdmin();
		ticket.setTicketId(results.getInt("ticket_id"));
		ticket.setEventName(results.getString("event_name"));
		ticket.setSection(results.getString("section"));
		ticket.setRow(results.getString("row"));
		ticket.setSeatNumber(results.getInt("seat_number"));
		ticket.setPrice(results.getBigDecimal("price"));

		return ticket;

	}
	
	public int nextTicketId() {
		int nextIdValue = 0;
		SqlRowSet nextId = template.queryForRowSet("SELECT nextval('available_tickets_ticket_id_seq')");
		if (nextId.next()) {
			nextIdValue = nextId.getInt(1);
		} else {
			throw new RuntimeException("Error getting the next Id.");
		}

		return nextIdValue;
	}
	
	public BigDecimal getTicketPrice(String chooseSectionPass) {
		if (chooseSectionPass.equals("Club")) {
			return new BigDecimal(300.00);
		} else if (chooseSectionPass.equals("First Class")) {
			return new BigDecimal(200.00);
		} else if (chooseSectionPass.equals("Mid Venue")) {
			return new BigDecimal(100.00);
		} else if (chooseSectionPass.equals("General Admission")) {
			return new BigDecimal(50.00);
		} else {

		}
		return new BigDecimal(0.00);

	}

}
