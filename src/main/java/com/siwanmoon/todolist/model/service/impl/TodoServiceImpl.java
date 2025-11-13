package com.siwanmoon.todolist.model.service.impl;

import static com.siwanmoon.todolist.common.ErrorMessage.TODO_ID_NOT_FOUND;

import com.siwanmoon.todolist.model.Todo;
import com.siwanmoon.todolist.model.TodoRepository;
import com.siwanmoon.todolist.model.service.TodoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>(todoRepository.findAll());

        todos.sort(Comparator.comparing(Todo::getDueDate, Comparator.nullsLast(Comparator.naturalOrder())));

        return todos;
    }

    @Override
    public void addTodo(String content, String dueDateInput) {
        LocalDate dueDate = null;

        if (dueDateInput != null && !dueDateInput.isBlank()) {
            dueDate = LocalDate.parse(dueDateInput);
        }

        todoRepository.save(content, dueDate);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void toggleImportant(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(TODO_ID_NOT_FOUND.getMessage() + id));

        todo.toggleImportant();
    }
}
