package com.siwanmoon.todolist.model.service;

import com.siwanmoon.todolist.model.Todo;
import java.util.List;

public interface TodoService {

    List<Todo> getTodos();
    void addTodo(String content, String dueDateInput);
    void deleteTodo(Long id);
    void toggleImportant(Long id);
    void toggleComplete(Long id);
    Todo getTodoById(Long id);
    void updateTodo(Long id, String content, String dueDateString);
}
