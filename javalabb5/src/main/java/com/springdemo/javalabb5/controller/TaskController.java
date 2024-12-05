package com.springdemo.javalabb5.controller;

import com.springdemo.javalabb5.model.Task;
import com.springdemo.javalabb5.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Страница со списком задач
    @GetMapping
    public String getTaskListPage(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list"; // Открывает task-list.html
    }

    // Форма добавления задачи
    @GetMapping("/form")
    public String getTaskFormPage() {
        return "task-form"; // Открывает task-form.html
    }

    // Создание задачи через форму
    @PostMapping("/form")
    public String createTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks"; // Перенаправляет на страницу со списком задач
    }
}
