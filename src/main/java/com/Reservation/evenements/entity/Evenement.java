package com.Reservation.evenements.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity

public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idEvent;

    private String eventname;

    private String description;

    private String type;

    @OneToMany(mappedBy = "evenement" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Reservation> reservations;

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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @ManyToOne
    private Admin admin;

    public Evenement(Long idEvent, String eventname, String description, String type, List<Reservation> reservations, Admin admin) {
        this.idEvent = idEvent;
        this.eventname = eventname;
        this.description = description;
        this.type = type;
        this.reservations = reservations;
        this.admin = admin;
    }

    public Evenement() {
    }
}
