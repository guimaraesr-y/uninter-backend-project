package com.uninter.todolist.todolist.todo.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record UpdateTodoDto(@NotBlank String nome,
                            @NotBlank String responsavel,
                            @DateTimeFormat @NotNull LocalDateTime dataEntrega) { }
