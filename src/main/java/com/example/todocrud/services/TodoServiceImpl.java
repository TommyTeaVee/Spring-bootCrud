package com.example.todocrud.services;

import com.example.todocrud.models.Todo;
import com.example.todocrud.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TodoServiceImpl implements TodoServices {
    TodoRepository todoRepository = null;
    public TodoServiceImpl(TodoRepository todoRepository){
     this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
   List<Todo> todos = new ArrayList<>();
   todoRepository.findAll().forEach(todos::add);
   return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo insert(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        Todo todofromDb = todoRepository.findById(id).get();
        System.out.println(todofromDb.toString());
        todofromDb.setTodoStatus(todo.getTodoStatus());
       todofromDb.setDescription(todo.getDescription());
       todofromDb.setTitle(todo.getTitle());
       todoRepository.save(todofromDb);

    }

    @Override
    public void deleteTodo(Long todoId) {
    todoRepository.deleteById(todoId);
    }
}
