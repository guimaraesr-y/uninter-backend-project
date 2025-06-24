package com.uninter.todolist.todolist.todo.application.dto;

import com.uninter.todolist.todolist.todo.domain.model.TodoItem;

import java.time.LocalDateTime;
import java.util.UUID;

public record TodoResponseDto(
    UUID id,
    String nome,
    String responsavel,
    boolean finalizado,
    LocalDateTime dataEntrega
) {
    public static TodoResponseDto fromDomain(TodoItem todo) {
        return new TodoResponseDto(
            todo.getId(),
            todo.getNome(),
            todo.getResponsavel(),
            todo.isFinalizado(),
            todo.getDataEntrega()
        );
    }
}
