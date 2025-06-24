package com.uninter.todolist.todolist.todo.application.dto;

import java.time.LocalDateTime;

public record CreateTodoDto(String nome, String responsavel, LocalDateTime dataEntrega) {
    public CreateTodoDto {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (responsavel == null || responsavel.isBlank()) {
            throw new IllegalArgumentException("Responsável não pode ser vazio");
        }
        if (dataEntrega == null) {
            throw new IllegalArgumentException("Data de entrega não pode ser nula");
        }
    }
}
