package com.Reservation.evenements.repository;


import com.Reservation.evenements.entity.Event;
import com.Reservation.evenements.entity.Reservation;
import com.Reservation.evenements.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByEvent(Event event);
}
