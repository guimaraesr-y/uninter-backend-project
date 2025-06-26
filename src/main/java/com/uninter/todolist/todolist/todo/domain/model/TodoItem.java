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
        this.nome = dto.nome();
        this.responsavel = dto.responsavel();
        this.dataEntrega = dto.dataEntrega();
    }
    
    public void markAsFinalizado() {
        this.finalizado = true;
    }
    
    public void markAsNaoFinalizado() {
        this.finalizado = false;
    }

}
