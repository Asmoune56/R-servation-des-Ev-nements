package com.Reservation.evenements.dto;

import com.Reservation.evenements.entity.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private UserRole role;
}
