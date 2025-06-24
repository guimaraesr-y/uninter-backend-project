package com.uninter.todolist.todolist.common.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationException extends BaseException {
    private final List<String> errors = new ArrayList<>();

    public ValidationException(String message) {
        super(HttpStatus.BAD_REQUEST, "validation_error", message);
    }

    public ValidationException(String message, List<String> errors) {
        this(message);
        this.errors.addAll(errors);
    }

}
