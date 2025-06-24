package com.uninter.todolist.todolist.todo.domain.model;

import com.uninter.todolist.todolist.todo.application.dto.CreateTodoDto;
import com.uninter.todolist.todolist.todo.application.dto.UpdateTodoDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor()
@AllArgsConstructor()
public class TodoItem {
    private UUID id;
    private String nome;
    private String responsavel;
    private boolean finalizado = false;
    private LocalDateTime dataEntrega;
    
    public static TodoItem create(CreateTodoDto dto) {
        TodoItem todo = new TodoItem();
        todo.nome = dto.nome();
        todo.responsavel = dto.responsavel();
        todo.dataEntrega = dto.dataEntrega();
        return todo;
    }
    
    public void update(UpdateTodoDto dto) {
        if (dto.nome() != null) {
            this.nome = dto.nome();
        }
        if (dto.responsavel() != null) {
            this.responsavel = dto.responsavel();
        }
        if (dto.dataEntrega() != null) {
            this.dataEntrega = dto.dataEntrega();
        }
        if (dto.finalizado() != null) {
            this.finalizado = dto.finalizado();
        }
    }
    
    public void markAsFinalizado() {
        this.finalizado = true;
    }
    
    public void markAsNaoFinalizado() {
        this.finalizado = false;
    }

}
