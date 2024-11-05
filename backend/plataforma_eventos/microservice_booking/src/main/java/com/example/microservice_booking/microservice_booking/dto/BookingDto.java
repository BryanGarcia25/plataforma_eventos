package com.example.microservice_booking.microservice_booking.dto;

import java.util.Date;

import com.example.microservice_event.microservice_event.entities.Event;
import com.example.microservice_users.microservice_users.entities.User;

public record BookingDto(Long id, User user, Event event, Date dateBooking, int numberPeople, String state, Date createdAt, Date updatedAt) { }
