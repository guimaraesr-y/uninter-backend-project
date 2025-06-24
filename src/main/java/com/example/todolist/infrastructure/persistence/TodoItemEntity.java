package com.example.todolist.infrastructure.persistence;

import com.example.todolist.domain.model.TodoItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "todo_items")
@NoArgsConstructor
@Getter
public class TodoItemEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String responsavel;
    
    @Column(nullable = false)
    private boolean finalizado = false;

    @Column(nullable = false)
    private LocalDateTime dataEntrega;
    
    public TodoItemEntity(TodoItem todoItem) {
        this.id = todoItem.getId();
        this.nome = todoItem.getNome();
        this.responsavel = todoItem.getResponsavel();
        this.finalizado = todoItem.isFinalizado();
        this.dataEntrega = todoItem.getDataEntrega();
    }

    public TodoItem toDomain() {
        TodoItem todoItem = new TodoItem(
                id,
                nome,
                responsavel,
                finalizado,
                dataEntrega
        );

        if (finalizado) {
            todoItem.markAsFinalizado();
        } else {
            todoItem.markAsNaoFinalizado();
        }

        return todoItem;
    }

}
