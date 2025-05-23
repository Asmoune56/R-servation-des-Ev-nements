package com.Reservation.evenements.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Admin extends User {

    public Admin() {
        this.setRole(Role.ADMIN);
    }

    @OneToMany(mappedBy = "admin" , cascade = CascadeType.ALL)
    private List<Evenement> evenements;


}
