package com.springdemo.javalabb5.service;

import com.springdemo.javalabb5.dto.ProfileUpdateDTO;
import com.springdemo.javalabb5.model.User;
import com.springdemo.javalabb5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    // Логика для обновления профиля
    public void updateProfile(Long userId, ProfileUpdateDTO profileUpdateDTO) throws Throwable {
        User user = (User) userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Обновляем данные профиля
        user.setUsername(profileUpdateDTO.getUsername());
        user.setEmail(profileUpdateDTO.getEmail());
        user.setPassword(profileUpdateDTO.getPassword()); // Пример для пароля

        userRepository.save(user); // Сохраняем обновленного пользователя
    }
}
