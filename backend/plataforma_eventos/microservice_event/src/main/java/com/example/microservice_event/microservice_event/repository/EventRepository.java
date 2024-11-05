package com.example.microservice_event.microservice_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice_event.microservice_event.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
}
