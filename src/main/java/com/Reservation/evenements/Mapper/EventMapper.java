package com.Reservation.evenements.Mapper;


import com.Reservation.evenements.dto.EventDto;
import com.Reservation.evenements.entity.Evenement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" ,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    EventDto eventToDto(Evenement evenement);
    Evenement dtoToEvent(EventDto eventDto);
}
