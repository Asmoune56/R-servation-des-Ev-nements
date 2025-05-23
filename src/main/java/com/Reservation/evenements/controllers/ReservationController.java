package com.Reservation.evenements.controllers;


import com.Reservation.evenements.dto.ReservatioDto;
import com.Reservation.evenements.service.ResrvationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {

    public ResrvationService resrvationService;

    @PostMapping("/addReservation")
    public ReservatioDto addReservation(@RequestBody ReservatioDto reservatioDto){
        return resrvationService.Resrever(reservatioDto);
    }

    @GetMapping("/allReservations")
    public List<ReservatioDto> getAllReservations(){
        return resrvationService.getAllReservation();
    }

    @GetMapping("/reservation/{id}")
    public ReservatioDto getreservationById(@PathVariable Long id ){
        return resrvationService.getReservationById(id);
    }
}
