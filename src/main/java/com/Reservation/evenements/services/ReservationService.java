package com.Reservation.evenements.services;


import com.Reservation.evenements.dto.ReservationRequest;
import com.Reservation.evenements.entities.Event;
import com.Reservation.evenements.entities.Reservation;
import com.Reservation.evenements.repositories.EventRepository;
import com.Reservation.evenements.repositories.ReservationRepository;
import com.Reservation.evenements.repositories.UserRepository;
import com.Reservation.evenements.entities.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public String makeReservation(ReservationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("المستخدم غير موجود"));

        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new RuntimeException("الحدث غير موجود"));

        if (event.getAvailableSeats() <= 0) {
            return "لا توجد مقاعد متاحة لهذا الحدث ❌";
        }

        Reservation reservation = Reservation.builder()
                .user(user)
                .event(event)
                .reservationDate(LocalDateTime.now())
                .build();

        reservationRepository.save(reservation);

        event.setAvailableSeats(event.getAvailableSeats() - 1);
        eventRepository.save(event);

        return "تم الحجز بنجاح ✅";
    }
}

