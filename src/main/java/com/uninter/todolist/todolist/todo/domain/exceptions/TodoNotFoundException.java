package com.uninter.todolist.todolist.todo.domain.exceptions;

import com.uninter.todolist.todolist.common.domain.exception.ResourceNotFoundException;

import java.util.UUID;

public class TodoNotFoundException extends ResourceNotFoundException {
    public TodoNotFoundException(UUID id) {
        super("Todo", id);
    }
}
