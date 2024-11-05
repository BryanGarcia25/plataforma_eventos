package com.example.microservice_event.microservice_event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice_event.microservice_event.dto.EventDto;
import com.example.microservice_event.microservice_event.service.EventServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/events")
public class EventController {
    
    private final EventServiceImpl eventServiceImpl;

    public EventController(EventServiceImpl eventServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
    }

    @PostMapping("/create_event")
    public String createEvent(@RequestBody EventDto eventDto) {
        return eventServiceImpl.createEvent(eventDto);
    }

    @GetMapping("/get_events")
    public List<EventDto> getAllEvents() {
        return eventServiceImpl.getAllEvents();
    }

    @GetMapping("/get_event/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        return eventServiceImpl.getEventById(id);
    }
    
    @PutMapping("/update_event/{id}")
    public String updateEventById(@PathVariable Long id, @RequestBody EventDto eventDto) {
        return eventServiceImpl.updateEventById(id, eventDto);
    }

    @DeleteMapping("/delete_event/{id}")
    public String deleteEventById(@PathVariable Long id) {
        return eventServiceImpl.deleteEventById(id);
    }

}
