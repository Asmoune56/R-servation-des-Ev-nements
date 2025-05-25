package com.Reservation.evenements.service;

import com.Reservation.evenements.Mapper.ReservationMapper;
import com.Reservation.evenements.dto.ReservatioDto;
import com.Reservation.evenements.entity.Client;
import com.Reservation.evenements.entity.Evenement;
import com.Reservation.evenements.entity.Reservation;
import com.Reservation.evenements.repository.ClientRepository;
import com.Reservation.evenements.repository.EventRepository;
import com.Reservation.evenements.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final EventRepository eventRepository;
    private final ReservationMapper reservationMapper;

    @Transactional
    public ReservatioDto reserver(ReservatioDto dto) {
        Client client = clientRepository.findById(dto.getClientid())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Evenement event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Reservation reservation = new Reservation(null, client, event);
        reservation = reservationRepository.save(reservation);

        return reservationMapper.reservationToDto(reservation);
    }

    public List<ReservatioDto> getAllReservation() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::reservationToDto)
                .toList();
    }

    public ReservatioDto getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::reservationToDto)
                .orElseThrow(() -> new RuntimeException("Reservation Not Found"));
    }
}
