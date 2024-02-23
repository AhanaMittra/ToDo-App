package com.example.todoapp.repository;


import com.example.todoapp.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListsRepository extends JpaRepository<TodoList, Integer> {
}
