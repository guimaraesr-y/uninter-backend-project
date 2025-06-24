package com.uninter.todolist.todolist.todo.interfaces.rest;

import com.uninter.todolist.todolist.todo.application.TodoService;
import com.uninter.todolist.todolist.todo.application.dto.CreateTodoDto;
import com.uninter.todolist.todolist.todo.application.dto.TodoResponseDto;
import com.uninter.todolist.todolist.todo.application.dto.UpdateTodoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@Valid @RequestBody CreateTodoDto request) {
        TodoResponseDto todo = todoService.createTodo(request);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todo.id())
                .toUri();
                
        return ResponseEntity.created(location).body(todo);
    }

    @GetMapping
    public List<TodoResponseDto> getAllTodos() {
        return todoService.getAllTodos();
    }


    @GetMapping("/{id}")
    public TodoResponseDto getTodoById(@PathVariable UUID id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateTodoDto request
    ) {
        return todoService.updateTodo(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable UUID id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/toggle-status")
    public TodoResponseDto toggleTodoStatus(@PathVariable UUID id) {
        return todoService.toggleTodoStatus(id);
    }

}
