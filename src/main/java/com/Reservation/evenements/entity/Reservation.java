package com.Reservation.evenements.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idReservation;
    @ManyToOne
    private Client client;

    @ManyToOne
    private Evenement evenement;

    public Client getClient() {
        return client;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public Long getIdReservation() {
        return idReservation;
    }


}
