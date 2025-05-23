package com.Reservation.evenements.dto;



public class ReservatioDto {
    private Long idReservation;
    private Long clientid;
    private Long eventId;


    public ReservatioDto(Long idReservation, Long clientid, Long eventId) {
        this.idReservation = idReservation;
        this.clientid = clientid;
        this.eventId = eventId;
    }

    public ReservatioDto() {
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
