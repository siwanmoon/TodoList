package com.siwanmoon.todolist.model.service;

import com.siwanmoon.todolist.model.Todo;
import java.util.List;

public interface TodoService {

    List<Todo> getTodos();
    void addTodo(String content);
    void deleteTodo(Long id);
}
