package com.Reservation.evenements.dto;


import lombok.Data;

@Data
public class ReservationDto {
    private Long id;
    private Long userId;
    private Long eventId;
    private int numberOfTickets;
}

