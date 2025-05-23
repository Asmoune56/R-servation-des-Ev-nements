package com.Reservation.evenements.service;


import com.Reservation.evenements.Mapper.ReservationMapper;
import com.Reservation.evenements.dto.ReservatioDto;
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
public class ResrvationService {


    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final EventRepository eventRepository;
    private ReservationMapper reservationMapper;

    @Transactional
    public ReservatioDto Resrever(ReservatioDto reservatioDto){
        var client = clientRepository.findById(reservatioDto.getClientid()).orElse(null);
        var event = eventRepository.findById(reservatioDto.getEventId()).orElse(null);

        var res = reservationRepository.save(new Reservation(null,client,event));
        return new ReservatioDto(res.getIdreservation(), res.getClient().getId(), res.getEvenement().getIdEvent());
    }

    public List<ReservatioDto> getAllReservation(){
        return reservationRepository.findAll().stream()
                .map(res->reservationMapper.reservationToDto(res))
                .toList();
    }

    public ReservatioDto getReservationById(Long id){
        return reservationRepository.findById(id)
                .map(ress->reservationMapper.reservationToDto(ress))
                .orElseThrow(()->new RuntimeException("Reservation Not Found"));
    }



}

