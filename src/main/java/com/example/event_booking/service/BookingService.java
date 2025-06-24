package com.example.event_booking.service;


import com.example.event_booking.model.Booking;
import com.example.event_booking.model.Event;
import com.example.event_booking.repository.BookingRepository;
import com.example.event_booking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    public Booking bookEvent(Long eventId, String username) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        Booking booking = new Booking(username, event);
        return bookingRepository.save(booking);
    }
}
