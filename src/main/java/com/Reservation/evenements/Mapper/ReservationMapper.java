package com.Reservation.evenements.Mapper;

import com.Reservation.evenements.dto.ReservatioDto;
import com.Reservation.evenements.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    //@Mapping(source = "idreservation", target = "idReservation")
    ReservatioDto reservationToDto(Reservation reservation);
    Reservation DtoToReservation(ReservatioDto dto);


}
