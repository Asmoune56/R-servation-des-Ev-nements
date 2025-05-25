package com.Reservation.evenements.controllers;

import com.Reservation.evenements.dto.ReservatioDto;
import com.Reservation.evenements.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/addReservation")
    public ReservatioDto addReservation(@RequestBody ReservatioDto reservatioDto){
        return reservationService.reserver(reservatioDto);
    }

    @GetMapping("/allReservations")
    public List<ReservatioDto> getAllReservations(){
        return reservationService.getAllReservation();
    }

    @GetMapping("/reservation/{id}")
    public ReservatioDto getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }
}
