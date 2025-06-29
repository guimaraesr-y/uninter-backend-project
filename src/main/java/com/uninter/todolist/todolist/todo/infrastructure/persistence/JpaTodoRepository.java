package com.uninter.todolist.todolist.todo.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaTodoRepository extends JpaRepository<TodoItemEntity, UUID> { }
