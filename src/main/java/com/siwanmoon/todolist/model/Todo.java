package com.siwanmoon.todolist.model;

import static com.siwanmoon.todolist.constant.ErrorMessage.TODO_CONTENT_BLANK;
import static com.siwanmoon.todolist.constant.ErrorMessage.TODO_CONTENT_LENGTH_OVERFLOW;
import static com.siwanmoon.todolist.constant.Strategy.MAX_CONTENT_LENGTH;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Todo {

    private Long id;
    private String content;
    private boolean completed;

    public Todo(Long id, String content) {
        validateContent(content);

        this.id = id;
        this.content = content;
        this.completed = false;
    }

    private void validateContent(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException(TODO_CONTENT_BLANK.getMessage());
        }

        if (content.length() > MAX_CONTENT_LENGTH) {
            throw new IllegalArgumentException(TODO_CONTENT_LENGTH_OVERFLOW.getMessage());
        }
    }
}
