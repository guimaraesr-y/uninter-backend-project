package com.uninter.todolist.todolist.todo.application.dto;

import java.time.LocalDateTime;

public record UpdateTodoDto(String nome, String responsavel, LocalDateTime dataEntrega, Boolean finalizado) {
    public UpdateTodoDto {
        if (nome != null && nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (responsavel != null && responsavel.isBlank()) {
            throw new IllegalArgumentException("Responsável não pode ser vazio");
        }
    }
}
