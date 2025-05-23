package com.Reservation.evenements.service;

import com.Reservation.evenements.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User update(Long id, User user);
    void delete(Long id);
}
