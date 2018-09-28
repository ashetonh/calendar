package com.harrell.projects.calendar.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;
	
	@Before
	public void setUp(){
		user = new User("Asheton");
	}
	
	@Test
	public void testGetNameReturnsProperly() {
		assertEquals("Asheton", user.getName());
	}
}
