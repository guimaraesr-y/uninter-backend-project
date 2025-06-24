package com.example.todolist.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TodoResponseDto(
    UUID id,
    String nome,
    String responsavel,
    boolean finalizado,
    LocalDateTime dataEntrega
) {
    public static TodoResponseDto fromDomain(com.example.todolist.domain.model.TodoItem todo) {
        return new TodoResponseDto(
            todo.getId(),
            todo.getNome(),
            todo.getResponsavel(),
            todo.isFinalizado(),
            todo.getDataEntrega()
        );
    }
}
