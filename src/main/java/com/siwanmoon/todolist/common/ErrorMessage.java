package com.siwanmoon.todolist.common;

import static com.siwanmoon.todolist.common.Strategy.MAX_CONTENT_LENGTH;
import static com.siwanmoon.todolist.common.Strategy.MAX_TODOLIST_SIZE;

public enum ErrorMessage {

    TODO_CONTENT_BLANK("내용을 입력해주세요."),
    TODO_CONTENT_LENGTH_OVERFLOW("내용은 " + MAX_CONTENT_LENGTH + "자를 초과할 수 없습니다."),
    TODOLIST_MAX_SIZE_OVERFLOW("Todo의 개수는" + MAX_TODOLIST_SIZE + "개를 초과할 수 없습니다."),
    TODO_ID_NOT_FOUND("ID에 해당하는 할 일을 찾을 수 없습니다: ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
