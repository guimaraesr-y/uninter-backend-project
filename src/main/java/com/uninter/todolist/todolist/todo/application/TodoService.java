package com.uninter.todolist.todolist.todo.application;

import com.uninter.todolist.todolist.todo.application.dto.CreateTodoDto;
import com.uninter.todolist.todolist.todo.application.dto.TodoResponseDto;
import com.uninter.todolist.todolist.todo.application.dto.UpdateTodoDto;
import com.uninter.todolist.todolist.todo.domain.exceptions.TodoNotFoundException;
import com.uninter.todolist.todolist.todo.domain.model.TodoItem;
import com.uninter.todolist.todolist.todo.domain.repository.TodoRepository;
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

    public TodoResponseDto getTodoById(UUID id) throws TodoNotFoundException {
        return todoRepository.findById(id)
                .map(TodoResponseDto::fromDomain)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Transactional
    public TodoResponseDto updateTodo(UUID id, UpdateTodoDto dto) throws TodoNotFoundException {
        TodoItem todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todo.update(dto);
        return TodoResponseDto.fromDomain(todoRepository.save(todo));
    }

    @Transactional
    public void deleteTodo(UUID id) throws TodoNotFoundException {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }

    @Transactional
    public TodoResponseDto toggleTodoStatus(UUID id) throws TodoNotFoundException {
        TodoItem todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        
        if (todo.isFinalizado()) {
            todo.markAsNaoFinalizado();
        } else {
            todo.markAsFinalizado();
        }
        
        return TodoResponseDto.fromDomain(todoRepository.save(todo));
    }

}
