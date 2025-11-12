package com.siwanmoon.todolist.model.service.impl;

import com.siwanmoon.todolist.model.Todo;
import com.siwanmoon.todolist.model.TodoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TodoService 로직 테스트")
class TodoServiceImplTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    @Test
    @DisplayName("getTodos() 호출 시, repository의 findAll()을 호출하고 리스트를 반환한다")
    void getTodos_shouldReturnList() {
        List<Todo> mockedList = mock(List.class);
        when(todoRepository.findAll()).thenReturn(mockedList);
        List<Todo> result = todoService.getTodos();
        assertEquals(mockedList, result);
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("addTodo()에 유효한 내용(content)을 전달하면, repository의 save()가 1번 호출된다")
    void addTodo_withValidContent_shouldCallSave() {
        String content = "스프링 공부하기";
        todoService.addTodo(content, null);
        verify(todoRepository, times(1)).save(content, null);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    @DisplayName("addTodo()에 null이나 공백(blank)이 전달되면, IllegalArgumentException을 던진다")
    void addTodo_withNullOrBlankContent_shouldThrowException(String invalidContent) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            todoService.addTodo(invalidContent, null);
        });

        assertEquals("내용을 입력해주세요.", exception.getMessage());
        verify(todoRepository, never()).save(anyString(), null);
    }

    @Test
    @DisplayName("deleteTodo()에 ID를 전달하면, repository의 deleteById()가 1번 호출된다")
    void deleteTodo_shouldCallDeleteById() {
        Long id = 1L;
        todoService.deleteTodo(id);
        verify(todoRepository, times(1)).deleteById(id);
    }
}
