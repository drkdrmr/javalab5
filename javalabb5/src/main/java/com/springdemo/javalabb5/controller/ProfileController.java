package com.springdemo.javalabb5.controller;

import com.springdemo.javalabb5.dto.ProfileUpdateDTO;
import com.springdemo.javalabb5.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Страница профиля
    @GetMapping("/view/{userId}")
    public String viewProfile(@PathVariable Long userId, Model model) {
        // Логика получения информации о пользователе
        // Например, передаем объект пользователя в модель
        model.addAttribute("userId", userId);
        return "profile"; // Страница профиля
    }

    // Обновление профиля
    @PostMapping("/update/{userId}")
    public String updateProfile(@PathVariable Long userId, ProfileUpdateDTO profileUpdateDTO, Model model) {
        try {
            profileService.updateProfile(userId, profileUpdateDTO); // Передаем ID и DTO
            model.addAttribute("success", true);
            return "redirect:/profile/view/" + userId; // Перенаправление на страницу профиля
        } catch (Throwable e) {
            model.addAttribute("error", "Error updating profile: " + e.getMessage());
            return "profile";
        }
    }
}
