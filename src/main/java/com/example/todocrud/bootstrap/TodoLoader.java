package com.example.todocrud.bootstrap;

import com.example.todocrud.models.Todo;
import com.example.todocrud.models.TodoStatus;
import com.example.todocrud.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoLoader implements CommandLineRunner {
    public final TodoRepository todoRepository;
    public TodoLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }
    private void loadTodos() {
        if (todoRepository.count() == 0) {
            todoRepository.save(
                    Todo.builder()
                            .title("Go to the Mall")
                            .description("Buy groceries from  Pick n Pay")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            todoRepository.save(
                    Todo.builder()
                            .title("Go to  workplace")
                            .description("Complete my tasks and standups")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Priority Todos Loaded");
        }
    }
}
