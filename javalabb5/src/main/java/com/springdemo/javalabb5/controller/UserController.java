package com.springdemo.javalabb5.controller;

import com.springdemo.javalabb5.model.User;
import com.springdemo.javalabb5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Регистрация пользователя
    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        try {
            userService.registerUser(user);
            model.addAttribute("success", true); // Успех
            return "redirect:/auth/login"; // Перенаправление на страницу входа
        } catch (Exception e) {
            model.addAttribute("error", "Error registering user: " + e.getMessage());
            return "register"; // Возвращаем на страницу регистрации
        }
    }

    // Получить пользователя по ID
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details"; // Страница с деталями пользователя
    }

    // Обновить пользователя
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user, Model model) {
        try {
            userService.updateUser(id, user);
            model.addAttribute("success", true);
            return "redirect:/user/" + id;
        } catch (Exception e) {
            model.addAttribute("error", "Error updating user: " + e.getMessage());
            return "user-details";
        }
    }
}
