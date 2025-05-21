package com.Reservation.evenements.dto;

import lombok.*;

@Data
public class ReservationRequest {
    private Long userId;
    private Long eventId;
}
