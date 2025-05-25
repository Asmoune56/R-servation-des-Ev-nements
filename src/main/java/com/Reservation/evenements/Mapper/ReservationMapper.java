package com.Reservation.evenements.Mapper;

import com.Reservation.evenements.dto.ReservatioDto;
import com.Reservation.evenements.entity.Client;
import com.Reservation.evenements.entity.Evenement;
import com.Reservation.evenements.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    @Mapping(source = "client.id", target = "clientid")
    @Mapping(source = "evenement.idEvent", target = "eventId")
    @Mapping(source = "idReservation", target = "idReservation")
    ReservatioDto reservationToDto(Reservation reservation);

    default Reservation dtoToReservation(ReservatioDto dto) {
        if (dto == null) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setIdReservation(dto.getIdReservation());

        // فقط إنشاء كائن Client و Evenement بالمعرفات (بدون بيانات أخرى)
        Client client = new Client();
        client.setId(dto.getClientid());
        reservation.setClient(client);

        Evenement evenement = new Evenement();
        evenement.setIdEvent(dto.getEventId());
        reservation.setEvenement(evenement);

        return reservation;
    }
}



