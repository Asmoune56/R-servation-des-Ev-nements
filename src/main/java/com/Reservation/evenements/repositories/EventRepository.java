package com.Reservation.evenements.repositories;


import com.Reservation.evenements.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDate(LocalDate date);


    List<Event> findByLocationContainingIgnoreCase(String location);


    List<Event> findByCategoryIgnoreCase(String category);


    List<Event> findByTitleContainingIgnoreCase(String keyword);
}

