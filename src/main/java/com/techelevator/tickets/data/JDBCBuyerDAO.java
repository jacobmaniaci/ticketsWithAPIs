package com.techelevator.tickets.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Buyer;

@Component
public class JDBCBuyerDAO implements BuyerDAO {
	
	private JdbcTemplate template;
	
	public JDBCBuyerDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public void createBuyer(Buyer buyer) {
		//int id = buyer.getBuyerId();
		String firstName = buyer.getFirstName();
		String lastName = buyer.getLastName();
		
		String sql = "INSERT INTO buyer (first_name, last_name) VALUES (?, ?)";
		template.update(sql, firstName, lastName);
	}

	@Override
	public List<Buyer> getAllBuyers() {
		String sql = "SELECT * FROM buyer";
		SqlRowSet result = template.queryForRowSet(sql);
		List<Buyer> output = new ArrayList<>();
		
		while(result.next()) {
			int id = result.getInt("buyer_id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			
			Buyer buyer = new Buyer(id, firstName, lastName);
			output.add(buyer);
			
		}
		
		return output;
	}

	@Override
	public Buyer getBuyer(int id) {
		String sql = "SELECT * FROM buyer WHERE buyer_id = ?";
		SqlRowSet result = template.queryForRowSet(sql, id);
		Buyer output = null;
		
		while(result.next()) {
			//int id = result.getInt("buyer_id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			
			output = new Buyer(id, firstName, lastName);
			
		}
		
		return output;
		
	}

	@Override
	public void updateBuyer(Buyer buyer, int id) {
		String sql = "UPDATE buyer SET first_name = ?, last_name = ? WHERE buyer_id = ?";
		String firstName = buyer.getFirstName();
		String lastName = buyer.getLastName();
		
		template.update(sql, firstName, lastName, id);
	}

	@Override
	public void deleteBuyer(int id) {
		String sql = "DELETE FROM buyer WHERE buyer_id =?";
		template.update(sql, id);
	}

}
