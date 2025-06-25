package com.uninter.todolist.todolist.todo.application.dto;

import com.uninter.todolist.todolist.common.domain.exception.ValidationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record CreateTodoDto(@NotBlank(message = "Nome não pode ser vazio")
                            String nome,
                            @NotBlank(message = "Responsável não pode ser vazio")
                            String responsavel,
                            @DateTimeFormat @NotNull(message = "Data de entrega é obrigatória")
                            LocalDateTime dataEntrega) { }
