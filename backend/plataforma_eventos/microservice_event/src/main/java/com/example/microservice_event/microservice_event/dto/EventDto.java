package com.example.microservice_event.microservice_event.dto;

import java.util.Date;

public record EventDto(Long id, String name, String description, String category, String address, Date dateEvent, int numberSeats, double price, Date createdAt) { }
