package com.example.microservice_booking.microservice_booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.microservice_booking.microservice_booking.constants.Messages;
import com.example.microservice_booking.microservice_booking.dto.BookingDto;
import com.example.microservice_booking.microservice_booking.entity.Booking;
import com.example.microservice_booking.microservice_booking.repository.BookingRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public String createBooking(BookingDto bookingDto) {
        Booking booking = new Booking(null, bookingDto.user(), bookingDto.event(), bookingDto.dateBooking(), bookingDto.numberPeople(), bookingDto.state(), bookingDto.createdAt(), bookingDto.updatedAt());

        bookingRepository.save(booking);

        return Messages.BOOKING_CREATED;
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream().map(booking -> new BookingDto(booking.getId(), booking.getUser(), booking.getEvent(), booking.getDateBooking(), booking.getNumberPeople(), booking.getState(), booking.getCreatedAt(), booking.getUpdatedAt())).toList();
    }

    @Override
    public BookingDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.BOOKING_NOTFOUND));

        return new BookingDto(booking.getId(), booking.getUser(), booking.getEvent(), booking.getDateBooking(), booking.getNumberPeople(), booking.getState(), booking.getCreatedAt(), booking.getUpdatedAt());
    }

    @Override
    public String updateBookingById(Long id, BookingDto bookingDto) {
        Booking bookingFound = bookingRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.BOOKING_NOTFOUND));

        bookingFound.setUser(bookingDto.user());
        bookingFound.setEvent(bookingDto.event());
        bookingFound.setDateBooking(bookingDto.dateBooking());
        bookingFound.setNumberPeople(bookingDto.numberPeople());
        bookingFound.setState(bookingDto.state());

        return Messages.BOOKING_UPDATED;
    }

    @Override
    public String deleteBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);

        if (!booking.isPresent()) {
            return Messages.BOOKING_NOTFOUND;
        }

        bookingRepository.deleteById(id);
        return Messages.BOOKING_DELETED;
    }
    
}
