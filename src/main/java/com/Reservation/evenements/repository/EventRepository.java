package com.Reservation.evenements.repository;

import com.Reservation.evenements.entity.Event;
import com.Reservation.evenements.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategory(EventCategory category);
    List<Event> findByLocationContainingIgnoreCase(String location);
    List<Event> findByDate(LocalDate date);
}
