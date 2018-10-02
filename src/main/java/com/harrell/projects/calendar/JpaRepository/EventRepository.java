package com.harrell.projects.calendar.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrell.projects.calendar.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
