package com.Reservation.evenements.dto;


import com.Reservation.evenements.entity.EventCategory;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDate date;
    private EventCategory category;
}

