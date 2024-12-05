package com.springdemo.javalabb5.controller;

import com.springdemo.javalabb5.model.User;
import com.springdemo.javalabb5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Страница входа
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Открывает login.html
    }

    // Страница регистрации
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User()); // Передаем пустой объект User для формы регистрации
        return "register"; // Открывает register.html
    }

    // Сохранение пользователя при регистрации
    @PostMapping("/register/save")
    public String registerUser(User user, Model model) {
        try {
            userService.registerUser(user); // Регистрируем пользователя через сервис
            model.addAttribute("success", true); // Отображаем успешное сообщение
            return "redirect:/auth/login"; // Перенаправление на страницу входа
        } catch (Exception e) {
            model.addAttribute("error", "Error registering user: " + e.getMessage()); // Ошибка при регистрации
            return "register"; // Возвращаем на страницу регистрации
        }
    }
}
