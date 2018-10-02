package com.harrell.projects.calendar.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrell.projects.calendar.model.Calendar;
import com.harrell.projects.calendar.model.Event;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

	void save(Event event);
	
}
