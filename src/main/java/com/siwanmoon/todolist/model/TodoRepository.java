package com.siwanmoon.todolist.model;

import static com.siwanmoon.todolist.constant.ErrorMessage.TODOLIST_MAX_SIZE_OVERFLOW;
import static com.siwanmoon.todolist.constant.Strategy.MAX_TODOLIST_SIZE;

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
        validateSize(todoList);
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

    private void validateSize (List<Todo> todoList) {
        if (todoList.size() >= MAX_TODOLIST_SIZE) {
            throw new IllegalArgumentException(TODOLIST_MAX_SIZE_OVERFLOW.getMessage());
        }
    }
}
