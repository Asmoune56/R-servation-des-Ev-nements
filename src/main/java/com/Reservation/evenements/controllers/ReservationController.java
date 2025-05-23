package com.Reservation.evenements.controllers;

import com.Reservation.evenements.dto.ReservationDto;
import com.Reservation.evenements.dto.ReservationMapper;
import com.Reservation.evenements.entity.Reservation;
import com.Reservation.evenements.service.ReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor

public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations()
                .stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.map(reservationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
    }

    @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto dto) {
        Reservation reservation = reservationMapper.toEntity(dto);
        return reservationMapper.toDto(reservationService.saveReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}

