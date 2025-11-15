package com.siwanmoon.todolist.controller;

import com.siwanmoon.todolist.model.Todo;
import com.siwanmoon.todolist.model.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todoService.getTodos());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam("content") String content,
                          @RequestParam(value = "dueDate", required = false) String dueDateInput,
                          RedirectAttributes redirectAttributes) {
        try {
            todoService.addTodo(content, dueDateInput);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String toggleImportant(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            todoService.toggleImportant(id);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String toggleComplete(@PathVariable("id") Long id,
                                 RedirectAttributes redirectAttributes) {

        try {
            todoService.toggleComplete(id);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Todo todo = todoService.getTodoById(id);
            model.addAttribute("todo", todo);
            return "edit";

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable("id") Long id,
                             @RequestParam("content") String content,
                             @RequestParam(value = "dueDate", required = false) String dueDateString,
                             RedirectAttributes redirectAttributes) {

        try {
            todoService.updateTodo(id, content, dueDateString);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());

            return "redirect:/edit/" + id;
        }

        return "redirect:/";
    }
}
