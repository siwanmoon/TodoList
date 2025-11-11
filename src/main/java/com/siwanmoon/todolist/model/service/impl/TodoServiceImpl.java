package com.siwanmoon.todolist.model.service.impl;

import static com.siwanmoon.todolist.constant.ErrorMessage.TODO_CONTENT_BLANK;

import com.siwanmoon.todolist.model.Todo;
import com.siwanmoon.todolist.model.TodoRepository;
import com.siwanmoon.todolist.model.service.TodoService;
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
        return todoRepository.findAll();
    }

    @Override
    public void addTodo(String content) {
        checkNotBlank(content);
        todoRepository.save(content);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    private void checkNotBlank(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException(TODO_CONTENT_BLANK.getMessage());
        }
    }
}
