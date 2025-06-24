package com.example.todolist.application;

import com.example.todolist.application.dto.CreateTodoDto;
import com.example.todolist.application.dto.TodoResponseDto;
import com.example.todolist.application.dto.UpdateTodoDto;
import com.example.todolist.domain.model.TodoItem;
import com.example.todolist.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponseDto createTodo(CreateTodoDto dto) {
        TodoItem todo = TodoItem.create(dto);
        return TodoResponseDto.fromDomain(todoRepository.save(todo));
    }

    public List<TodoResponseDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(TodoResponseDto::fromDomain)
                .collect(Collectors.toList());
    }

    public TodoResponseDto getTodoById(UUID id) {
        return todoRepository.findById(id)
                .map(TodoResponseDto::fromDomain)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado com o id: " + id));
    }

    @Transactional
    public TodoResponseDto updateTodo(UUID id, UpdateTodoDto dto) {
        TodoItem todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado com o id: " + id));
        todo.update(dto);
        return TodoResponseDto.fromDomain(todoRepository.save(todo));
    }

    @Transactional
    public void deleteTodo(UUID id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo não encontrado com o id: " + id);
        }
        todoRepository.deleteById(id);
    }

    @Transactional
    public TodoResponseDto toggleTodoStatus(UUID id) {
        TodoItem todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo não encontrado com o id: " + id));
        
        if (todo.isFinalizado()) {
            todo.markAsNaoFinalizado();
        } else {
            todo.markAsFinalizado();
        }
        
        return TodoResponseDto.fromDomain(todoRepository.save(todo));
    }

    public static class TodoNotFoundException extends RuntimeException {
        public TodoNotFoundException(String message) {
            super(message);
        }
    }

}
