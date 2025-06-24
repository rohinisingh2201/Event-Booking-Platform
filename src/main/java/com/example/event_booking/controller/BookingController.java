package com.example.event_booking.controller;

import com.example.event_booking.model.Booking;
import com.example.event_booking.repository.BookingRepository;
import com.example.event_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Book an event
    @PostMapping
    public Booking bookEvent(@RequestParam Long eventId, @RequestParam String userName) {
        return bookingService.bookEvent(eventId, userName);
    }

}
