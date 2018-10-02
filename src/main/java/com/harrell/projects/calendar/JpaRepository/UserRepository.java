package com.harrell.projects.calendar.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harrell.projects.calendar.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
