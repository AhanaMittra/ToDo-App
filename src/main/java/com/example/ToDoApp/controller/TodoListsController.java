package com.example.ToDoApp.controller;

import com.example.ToDoApp.entity.TodoList;
import com.example.ToDoApp.service.TodoListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListsController {

    @Autowired
    private TodoListsService todoListsService;

    @GetMapping("/todolists")
    public List<TodoList> getAllTodoLists(){
        return todoListsService.getAllTodoLists();
    }

    @PostMapping("/todolists")
    public TodoList createTodoList(@RequestBody TodoList todoList){
        return todoListsService.createTodoLists(todoList);
    }

    @PutMapping("todolists/{id}")
    public TodoList updateTodoList(@RequestBody TodoList todoList, @PathVariable int id){
        return todoListsService.updateTodoLists(todoList, id);
    }

    @DeleteMapping("/todolists/{id}")
    public void deleteTodoList(@PathVariable int id){
        todoListsService.deleteTodoList(id);
    }
}
