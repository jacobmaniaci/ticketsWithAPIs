package com.techelevator.tickets.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		String sql = "INSERT INTO section (section_name, section_price) "
				+ "VALUES (?, ?)";
		String sectionName = section.getSectionName();
		BigDecimal sectionPrice = section.getSectionPrice().setScale(2, RoundingMode.HALF_UP);
		

			template.update(sql, sectionName, sectionPrice);
		}
		
	

	@Override
	public List<Section> getAllSections() {
		String sql = "SELECT * FROM section";
		SqlRowSet result = template.queryForRowSet(sql);
		List<Section> output = new ArrayList<>();

		while (result.next()) {
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
		String sql = "SELECT * FROM section WHERE section_id = ?";
		Section output = null;
		SqlRowSet results = template.queryForRowSet(sql, id);
		
		while(results.next()) {
			String sectionName = results.getString("section_name");
			BigDecimal sectionPrice = results.getBigDecimal("section_price");
			
			output = new Section(id, sectionName, sectionPrice);
		}
		return output;
	}

	@Override
	public void updateSection(Section section, int id) {
		String sql = "UPDATE section SET section_name = ?, section_price = ? WHERE section_id = ?";
		String sectionName = section.getSectionName();
		BigDecimal sectionPrice = section.getSectionPrice();
		
		template.update(sql, sectionName, sectionPrice, id);
	}

	@Override
	public void deleteSection(int id) {
		String sql = "DELETE FROM section WHERE section_id = ?";
		template.update(sql, id);
	}

}
