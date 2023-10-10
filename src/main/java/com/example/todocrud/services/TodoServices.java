package com.example.todocrud.services;

import com.example.todocrud.models.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

public interface TodoServices {
    List<Todo> getTodos();
    Todo getTodoById(Long id);
    Todo insert(Todo todo);
    void updateTodo(Long id, Todo todo);
    void deleteTodo(Long todoId);
}
