package com.example.microservice_booking.microservice_booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservice_booking.microservice_booking.dto.BookingDto;

@Service
public interface BookingService {
    
    String createBooking(BookingDto bookingDto);
    List<BookingDto> getAllBookings();
    BookingDto getBookingById(Long id);
    String updateBookingById(Long id, BookingDto bookingDto);
    String deleteBookingById(Long id);

}
