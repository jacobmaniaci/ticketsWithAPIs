package com.techelevator.tickets.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tickets.models.Section;

@Component
public class JDBCSectionDAO implements SectionDAO {
	
	private JdbcTemplate template;
	
	public JDBCSectionDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public void createSection(Section section) {
		
		
	}

	@Override
	public List<Section> getAllSections() {
		String sql = "SELECT * FROM section";
		SqlRowSet result = template.queryForRowSet(sql);
		List<Section> output = new ArrayList<>();
		
		while(result.next()) {
			int id = result.getInt("section_id");
			String sectionName = result.getString("section_name");
			BigDecimal sectionPrice = result.getBigDecimal("section_price");
			
			Section section = new Section(id, sectionName, sectionPrice);
			output.add(section);
			
		}
		
		return output;
	
	}

	@Override
	public Section getSection(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSection(Section section) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSection(int id) {
		// TODO Auto-generated method stub
		
	}

}
