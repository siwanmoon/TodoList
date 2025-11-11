package com.siwanmoon.todolist.constant;

public enum ErrorMessage {

    TODO_CONTENT_BLANK("내용을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
