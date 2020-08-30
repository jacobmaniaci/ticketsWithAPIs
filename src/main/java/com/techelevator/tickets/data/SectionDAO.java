package com.techelevator.tickets.data;

import java.util.List;

import com.techelevator.tickets.models.Section;

public interface SectionDAO {
	
	public void createSection(Section section);
	public List<Section> getAllSections();
	public Section getSection(int id);
	public void updateSection(Section section, int id);
	public void deleteSection(int id);
	
}
