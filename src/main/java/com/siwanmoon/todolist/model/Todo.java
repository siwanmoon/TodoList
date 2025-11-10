package com.siwanmoon.todolist.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Todo {

    private Long id;
    private String content;
    private boolean completed;

    public Todo(String content) {
        this.content = content;
        this.completed = false;
    }
}
