package com.example.todolist.domain.repository;

import com.example.todolist.domain.model.TodoItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {

    TodoItem save(TodoItem todoItem);
    Optional<TodoItem> findById(UUID id);
    List<TodoItem> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);

}
