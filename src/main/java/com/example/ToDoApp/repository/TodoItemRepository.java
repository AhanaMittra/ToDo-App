package com.example.ToDoApp.repository;

import com.example.ToDoApp.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {
    List<TodoItem> findByTodoListId(int todoListId);
}
