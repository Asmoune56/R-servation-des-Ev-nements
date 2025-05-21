package com.Reservation.evenements.services;



import com.Reservation.evenements.dto.AuthResponse;
import com.Reservation.evenements.dto.LoginRequest;
import com.Reservation.evenements.dto.RegisterRequest;
import com.Reservation.evenements.entities.Role;
import com.Reservation.evenements.repositories.RoleRepository;
import com.Reservation.evenements.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // تسجيل مستخدم جديد
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new AuthResponse(null, "البريد الإلكتروني مسجل بالفعل");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("الدور ROLE_USER غير موجود"));

        com.example.eventbooking.entities.User user = com.example.eventbooking.entities.User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(userRole))
                .build();

        userRepository.save(user);

        return new AuthResponse(null, "تم التسجيل بنجاح ✅");
    }

    // تسجيل الدخول
    public AuthResponse login(LoginRequest request) {
        Optional<com.example.eventbooking.entities.User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return new AuthResponse(null, "المستخدم غير موجود ❌");
        }

        com.example.eventbooking.entities.User user = optionalUser.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse(null, "كلمة المرور غير صحيحة ❌");
        }

        // في المرحلة القادمة نضيف JWT Token هنا
        return new AuthResponse("jwt-token-will-go-here", "تم تسجيل الدخول بنجاح ✅");
    }
}

