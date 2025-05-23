package com.Reservation.evenements.service;



import com.Reservation.evenements.entity.Event;
import com.Reservation.evenements.entity.EventCategory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event saveEvent(Event event);
    Optional<Event> getEventById(Long id);
    List<Event> getAllEvents();
    void deleteEvent(Long id);

    List<Event> getEventsByCategory(EventCategory category);
    List<Event> getEventsByLocation(String location);
    List<Event> getEventsByDate(LocalDate date);
}



