package com.siwanmoon.todolist.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    private final List<Todo> todoList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public void save(String content, LocalDate dueDate) {
        Long id = idCounter.incrementAndGet();
        Todo newTodo = new Todo(id, content, dueDate);
        todoList.add(newTodo);
    }

    public List<Todo> findAll() {
        return Collections.unmodifiableList(todoList);
    }

    public void deleteById(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }
}
