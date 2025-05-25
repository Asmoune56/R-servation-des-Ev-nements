package com.Reservation.evenements.Mapper;


import com.Reservation.evenements.dto.ClientDto;
import com.Reservation.evenements.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    // تحويل من Entity إلى DTO بدون كلمة المرور
    @Mapping(target = "password", ignore = true)
    ClientDto toClientDto(Client client);

    // عند التحويل من DTO إلى Entity، نسمح بكلمة المرور (لأنها ستُشفّر قبل الحفظ)
    Client toCliententity(ClientDto clientDto);
}
