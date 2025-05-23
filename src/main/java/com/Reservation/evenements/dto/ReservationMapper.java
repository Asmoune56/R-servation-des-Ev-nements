package com.Reservation.evenements.dto;


import com.Reservation.evenements.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDto toDto(Reservation reservation);

    Reservation toEntity(ReservationDto dto);
}


