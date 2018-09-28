package com.harrell.projects.calendar.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalendarTest {

	private Calendar calendar;
	
	@Before
	public void setUp(){
		calendar = new Calendar(new User("Asheton"), "My Calendar");
	}
	
	@Test
	public void testCalendarHasUserNotNull() {
		assertNotNull(calendar.getUser());
	}
	
	@Test
	public void testCalendarHasName() {
		assertEquals("My Calendar", calendar.getName());
	}

}
