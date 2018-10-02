package com.harrell.projects.calendar.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harrell.projects.calendar.JpaRepository.CalendarRepository;
import com.harrell.projects.calendar.JpaRepository.EventRepository;
import com.harrell.projects.calendar.JpaRepository.UserRepository;
import com.harrell.projects.calendar.exception.EventNotFoundException;
import com.harrell.projects.calendar.model.Event;

import lombok.extern.log4j.Log4j;


@RestController
@Log4j
@RequestMapping("/api")
public class CalendarController {
	
	
	private static Logger log = LoggerFactory.getLogger(CalendarController.class);
	private final CalendarRepository calendarRepository;
	private final EventRepository eventRepository;
	
	CalendarController(CalendarRepository calendarRepository, EventRepository eventRepository){
		this.calendarRepository = calendarRepository;
		this.eventRepository = eventRepository;
	}
	
	/*
	 * Our create meeting mapping which updates the local h2 with a new event if you hit a url with a correct calendarId.
	 * Not creating multiple params due to time, but will come back to update.
	 * */
	@PostMapping(value="/{calendarId}/create-meeting")
	public ResponseEntity<Event> createMeeting(@PathVariable("calendarId") long calendarId, @RequestBody(required = false) Event event) {
		event = null;
		
		if(this.calendarRepository.findById(calendarId) != null) {
			// creating a random test event for now, but thought about adding either a form at this level or adding in request parameters for each of the table updates.
			event = new Event(this.calendarRepository.findById(calendarId).get(), "testTitle", LocalDateTime.now(), "location", new ArrayList<String>(), "reminder", false);
			this.eventRepository.save(event);
			log.info("Saving event with event id: " + event.getId());
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
			log.info("adding headers and sending status created");
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@GetMapping(value="/{calendarId}/get-meetings")
	public List<Event> getMeetings(@PathVariable("calendarId") long calendarId) throws EventNotFoundException {
		if(this.calendarRepository.findById(calendarId) != null) {
			log.info("calendar repository has this calendar and is returning all events");
			return this.eventRepository.findAll();
		}
		
		throw new EventNotFoundException("You have no events.");
	}
	
	@GetMapping(value="/{calendarId}/get-meeting/{meetingId}")
	public Event getMeetingById(@PathVariable("calendarId") long calendarId, @PathVariable("meetingId") long meetingId) throws EventNotFoundException {
		if(this.calendarRepository.findById(calendarId) != null && this.eventRepository.findById(meetingId) != null) {
			log.info("getting event from calendar with calendarId: " + calendarId + "and event id: " + meetingId);
			return this.eventRepository.findById(meetingId).get();
		}
		throw new EventNotFoundException("id: " + meetingId);
	}
	
	@PutMapping(value="{calendarId}/update-meeting/{eventId}")
	public ResponseEntity<Object> updateMeeting(@PathVariable long calendarId,@PathVariable long eventId,  @RequestBody Event event) {

		Optional<Event> possibleEvent = this.eventRepository.findById(eventId);
		if(this.calendarRepository.findById(calendarId) != null && possibleEvent.isPresent()) {
			event.setId(eventId);
			this.eventRepository.save(event);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value="{calendarId}/delete-meeting/{eventId}")
	public void deleteMeeting(@PathVariable Long calendarId, @PathVariable long eventId) {
		if(this.calendarRepository.findById(calendarId) != null) {
			this.eventRepository.deleteById(eventId);
		}
	}

}
