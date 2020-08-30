package com.techelevator.tickets.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.tickets.models.Buyer;

public class JDBCBuyerTest {
	
	private JDBCBuyerDAO dao;
	
	private static SingleConnectionDataSource dataSource;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("Starting test");
		String sqlInsertCampground = "";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCampground);
		dao = new JDBCBuyerDAO(dataSource);
	}
	
	@Test
	public void createBuyerTest() {
		Buyer buyer = new Buyer(99999999, "Test", "Tester");
		List<Buyer> results = new ArrayList<Buyer>();
		results = dao.getAllBuyers();
		results.add(buyer);
		
		boolean actual = results.contains(buyer);
		
		assertEquals(true, actual);
		
	}

}
