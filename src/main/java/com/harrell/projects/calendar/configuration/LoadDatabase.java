package com.harrell.projects.calendar.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.harrell.projects.calendar.JpaRepository.CalendarRepository;
import com.harrell.projects.calendar.model.Calendar;
import com.harrell.projects.calendar.model.User;
@Configuration
class LoadDatabase {
	
	

	@Bean
	CommandLineRunner initDatabase(CalendarRepository repository) {
		return args -> {
			System.out.println("Loading a bean Calendar bean: ");
			repository.save(new Calendar(new User("Asheton"), "My Calendar"));
		};
	}
}
