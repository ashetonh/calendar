package com.harrell.projects.calendar.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;



@Data
@Entity(name="event")
public class Event {

	
	
	private static Long counter = 0l;
	private @Id Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Calendar calendar;
	private String title;
	private LocalDateTime dateTime;
	private String location;
	@ElementCollection
	private List<String> attendees;
	private String reminder;
	private boolean reminderSent;
	public Event() {}
	public Event(Calendar calendar, String title, LocalDateTime dateTime, String location,
			List<String> attendees, String reminder, boolean reminderSent) {
		this.id = ++counter;
		this.calendar = calendar;
		this.title = title;
		this.dateTime = dateTime;
		this.location = location;
		this.attendees = attendees;
		this.reminder = reminder;
		this.reminderSent = reminderSent;
	}
	
	
	public Long getId() { 
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public boolean isReminderSent() {
		return reminderSent;
	}

	public void setReminderSent(boolean reminderSent) {
		this.reminderSent = reminderSent;
	}


	@Override
	public String toString() {
		return "Event [calendar=" + calendar + ", title=" + title + ", dateTime=" + dateTime + ", location=" + location
				+ ", attendees=" + attendees + ", reminder=" + reminder + ", reminderSent=" + reminderSent + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendees == null) ? 0 : attendees.hashCode());
		result = prime * result + ((calendar == null) ? 0 : calendar.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((reminder == null) ? 0 : reminder.hashCode());
		result = prime * result + (reminderSent ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (attendees == null) {
			if (other.attendees != null)
				return false;
		} else if (!attendees.equals(other.attendees))
			return false;
		if (calendar == null) {
			if (other.calendar != null)
				return false;
		} else if (!calendar.equals(other.calendar))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (reminder == null) {
			if (other.reminder != null)
				return false;
		} else if (!reminder.equals(other.reminder))
			return false;
		if (reminderSent != other.reminderSent)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	
	
}