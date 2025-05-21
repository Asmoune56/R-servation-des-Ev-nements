package com.Reservation.evenements.repositories;



import com.Reservation.evenements.entities.Reservation;
import com.Reservation.evenements.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}
