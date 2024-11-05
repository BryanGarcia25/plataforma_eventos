package com.example.microservice_booking.microservice_booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice_booking.microservice_booking.dto.BookingDto;
import com.example.microservice_booking.microservice_booking.service.BookingServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    
    private final BookingServiceImpl bookingServiceImpl;

    public BookingController(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl = bookingServiceImpl;
    }

    @PostMapping("/create_booking")
    public String createBooking(@RequestBody BookingDto bookingDto) {
        return bookingServiceImpl.createBooking(bookingDto);
    }

    @GetMapping("/get_bookings")
    public List<BookingDto> getAllBookings() {
        return bookingServiceImpl.getAllBookings();
    }

    @GetMapping("/get_booking/{id}")
    public BookingDto getBookingById(@PathVariable Long id) {
        return bookingServiceImpl.getBookingById(id);
    }
    
    @PutMapping("/update_booking/{id}")
    public String updateBookingById(@PathVariable Long id, @RequestBody BookingDto bookingDto) {
        return bookingServiceImpl.updateBookingById(id, bookingDto);
    }
    
    @DeleteMapping("/delete_booking/{id}")
    public String updateBookingById(@PathVariable Long id) {
        return bookingServiceImpl.deleteBookingById(id);
    }
}
