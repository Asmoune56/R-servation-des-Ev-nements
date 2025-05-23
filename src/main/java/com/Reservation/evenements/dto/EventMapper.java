package com.Reservation.evenements.dto;

import com.Reservation.evenements.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // هذا ضروري لجعل MapStruct يولّد Bean يمكن لـ Spring استخدامه
public interface EventMapper {
    EventDto toDto(Event event);
    Event toEntity(EventDto dto);
}
