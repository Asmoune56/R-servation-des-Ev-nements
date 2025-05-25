package com.Reservation.evenements;


import com.Reservation.evenements.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User user) {
        // تشفير كلمة المرور
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // حفظ المستخدم في قاعدة البيانات
        userRepository.save(user);
    }
}

