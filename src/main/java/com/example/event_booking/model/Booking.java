package com.example.event_booking.model;


import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToOne
    private Event event;

    public Booking() {}

    public Booking(String username, Event event) {
        this.username = username;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public Event getEvent() {
        return event;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
