package com.Reservation.evenements.dto;





public class EventDto {

    private Long idEvent;
    private String eventname;
    private String description;
    private String type;

    public EventDto(Long idEvent, String eventname, String description, String type) {
        this.idEvent = idEvent;
        this.eventname = eventname;
        this.description = description;
        this.type = type;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
