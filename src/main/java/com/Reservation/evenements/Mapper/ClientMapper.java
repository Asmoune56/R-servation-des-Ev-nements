package com.Reservation.evenements.Mapper;


import com.Reservation.evenements.dto.ClientDto;
import com.Reservation.evenements.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toClientDto(Client client);
    Client toCliententity(ClientDto clientDto);

}
