package com.Reservation.evenements.dto;

import lombok.*;

@Data
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String phone;
}
