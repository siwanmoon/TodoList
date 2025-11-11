package com.siwanmoon.todolist.controller;

import com.siwanmoon.todolist.model.Todos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    private final Todos todos;

    public TodoController(Todos todos) {
        this.todos = todos;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todos.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam("content") String content) {
        todos.add(content);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todos.deleteById(id);
        return "redirect:/";
    }
}
