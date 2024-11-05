package com.example.microservice_event.microservice_event.service;

import java.util.List;

import com.example.microservice_event.microservice_event.dto.EventDto;

public interface EventService {
    
    String createEvent(EventDto eventDto);
    List<EventDto> getAllEvents();
    EventDto getEventById(Long id);
    String updateEventById(Long id, EventDto eventDto);
    String deleteEventById(Long id);

}
