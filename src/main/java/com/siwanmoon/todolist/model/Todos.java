package com.siwanmoon.todolist.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Todos {

    private final List<Todo> todoList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public void add(String content) {
        Long id = idCounter.incrementAndGet();
        Todo newTodo = new Todo(content);
        todoList.add(newTodo);
    }

    public List<Todo> findAll() {
        return Collections.unmodifiableList(todoList);
    }

    public void deleteById(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }
}
