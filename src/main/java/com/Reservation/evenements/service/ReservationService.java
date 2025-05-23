package com.Reservation.evenements.service;



import com.Reservation.evenements.entity.Event;
import com.Reservation.evenements.entity.Reservation;
import com.Reservation.evenements.entity.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    Optional<Reservation> getReservationById(Long id);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByUser(User user);
    List<Reservation> getReservationsByEvent(Event event);
    void deleteReservation(Long id);

}


