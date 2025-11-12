package com.siwanmoon.todolist.model.service;

import com.siwanmoon.todolist.model.Todo;
import java.util.List;

public interface TodoService {

    List<Todo> getTodos();
    void addTodo(String content, String dueDateInput);
    void deleteTodo(Long id);
}
