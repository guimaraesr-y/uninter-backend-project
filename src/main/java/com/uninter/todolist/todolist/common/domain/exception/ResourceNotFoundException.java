package com.uninter.todolist.todolist.common.domain.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String resourceName, Object id) {
        super(
            HttpStatus.NOT_FOUND,
            "resource_not_found",
            String.format("%s não encontrado com o ID: %s", resourceName, id)
        );
    }
}
