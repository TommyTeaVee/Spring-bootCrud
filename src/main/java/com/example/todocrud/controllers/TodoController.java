package com.example.todocrud.controllers;
;
import com.example.todocrud.models.Todo;
import com.example.todocrud.services.TodoServices;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    TodoServices todoServices;
    public TodoController(TodoServices todoServices){
        this.todoServices = todoServices;
    }


//The function receives a GET request, processes it and gives back a list of Todo as a response.ack a list of Todo as a response.
@GetMapping
public ResponseEntity<List<Todo>> getAllTodos() {
    List<Todo> todos = todoServices.getTodos();
    return new ResponseEntity<>(todos, HttpStatus.OK);
}
    //The function receives a GET request, processes it, and gives back a list of Todo as a response.
    @GetMapping({"/{todoId}"})
    public ResponseEntity<Todo> getTodo(@PathVariable Long todoId) {
        return new ResponseEntity<>(todoServices.getTodoById(todoId), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new Todo and saves it to the database, and returns a resource link to the created todo.@PostMapping
    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo todo1 = todoServices.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/v1/todo/" + todo1.getId().toString());
        return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
    }

    //The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo
    @PutMapping({"/{todoId}"})
    public ResponseEntity<Todo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo todo) {
        todoServices.updateTodo(todoId, todo);
        return new ResponseEntity<>(todoServices.getTodoById(todoId), HttpStatus.OK);
    }


    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{todoId}"})
    public ResponseEntity<Todo> deleteTodo(@PathVariable("todoId") Long todoId) {
        todoServices.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}








