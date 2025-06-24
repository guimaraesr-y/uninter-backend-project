package com.uninter.todolist.todolist.todo.infrastructure.persistence;

import com.uninter.todolist.todolist.todo.domain.model.TodoItem;
import com.uninter.todolist.todolist.todo.domain.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DomainTodoRepository implements TodoRepository {

    private final JpaTodoRepository entities;

    public DomainTodoRepository(JpaTodoRepository entities) {
        this.entities = entities;
    }

    @Override
    public TodoItem save(TodoItem todo) {
        TodoItemEntity entity = new TodoItemEntity(todo);
        TodoItemEntity saved = entities.saveAndFlush(entity);
        return saved.toDomain();
    }

    @Override
    public Optional<TodoItem> findById(UUID id) {
        return entities.findById(id)
                .map(TodoItemEntity::toDomain);
    }

    @Override
    public List<TodoItem> findAll() {
        return entities.findAll()
                .stream()
                .map(TodoItemEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        entities.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return entities.existsById(id);
    }

}
