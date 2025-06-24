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
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private boolean completed;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    public TodoItemEntity(TodoItem todoItem) {
        this.id = todoItem.getId();
        this.title = todoItem.getTitle();
        this.description = todoItem.getDescription();
        this.completed = todoItem.isCompleted();
        this.createdAt = todoItem.getCreatedAt();
        this.updatedAt = todoItem.getUpdatedAt();
    }

    public TodoItem toDomain() {
        TodoItem todoItem = new TodoItem(title, description);
        todoItem.setCompleted(completed);
        return todoItem;
    }

}
