package com.example.microservice_event.microservice_event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.microservice_event.microservice_event.constants.Messages;
import com.example.microservice_event.microservice_event.dto.EventDto;
import com.example.microservice_event.microservice_event.entities.Event;
import com.example.microservice_event.microservice_event.repository.EventRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public String createEvent(EventDto eventDto) {
        Event event = new Event(eventDto.id(), eventDto.name(), eventDto.description(), eventDto.category(), eventDto.address(), eventDto.dateEvent(), eventDto.numberSeats(), eventDto.price(), eventDto.createdAt());

        eventRepository.save(event);
        
        return Messages.EVENT_PUBLISHED;
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();

        return events.stream().map(event -> new EventDto(event.getId(), event.getName(), event.getDescription(), event.getCategory(), event.getAddress(), event.getDateEvent(), event.getNumberSeats(), event.getPrice(), event.getCreatedAt())).toList();
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.EVENT_NOTFOUND));

        return new EventDto(event.getId(), event.getName(), event.getDescription(), event.getCategory(), event.getAddress(), event.getDateEvent(), event.getNumberSeats(), event.getPrice(), event.getCreatedAt());        
    }

    @Override
    public String updateEventById(Long id, EventDto eventDto) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.EVENT_NOTFOUND));

        event.setName(eventDto.name());
        event.setDescription(eventDto.description());
        event.setCategory(eventDto.category());
        event.setAddress(eventDto.address());
        event.setDateEvent(eventDto.dateEvent());
        event.setNumberSeats(eventDto.numberSeats());
        event.setPrice(eventDto.price());

        eventRepository.save(event);

        return Messages.EVENT_UPDATED;
    }

    @Override
    public String deleteEventById(Long id) {
        Optional<Event> eventFound = eventRepository.findById(id);

        if (!eventFound.isPresent()) {
            return Messages.EVENT_NOTFOUND;
        }

        eventRepository.deleteById(id);
        return Messages.EVENT_DELETED;
    }
    
}
