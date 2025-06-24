package com.example.event_booking.controller;

import com.example.event_booking.model.Booking;
import com.example.event_booking.repository.BookingRepository;
import com.example.event_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    // Book an event
    @PostMapping
    public Booking bookEvent(@RequestParam Long eventId, @RequestParam String userName) {
        return bookingService.bookEvent(eventId, userName);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    @GetMapping("/summary")
    public List<Map<String, Object>> getBookingSummary() {
        return bookingRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Booking::getEvent,
                        LinkedHashMap::new,
                        Collectors.mapping(Booking::getUserName, Collectors.toList())
                ))
                .entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("eventId", entry.getKey().getId());
                    map.put("eventName", entry.getKey().getName());
                    map.put("userNames", entry.getValue());
                    map.put("count", entry.getValue().size());
                    return map;
                }).collect(Collectors.toList());
    }



}
