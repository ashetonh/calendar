package com.harrell.projects.calendar.exception;

public class EventNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EventNotFoundException(String message){
		super(message);
	}

}
