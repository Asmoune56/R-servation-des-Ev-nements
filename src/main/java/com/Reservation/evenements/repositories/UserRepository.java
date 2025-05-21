package com.Reservation.evenements.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<com.example.eventbooking.entities.User, Long> {
    Optional<com.example.eventbooking.entities.User> findByEmail(String email);
    boolean existsByEmail(String email);
}

