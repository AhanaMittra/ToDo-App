package com.example.ToDoApp.controller;

import com.example.ToDoApp.entity.TodoItem;
import com.example.ToDoApp.service.TodoItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolists")
public class TodoItemsController {

    @Autowired
    private TodoItemsService todoItemsService;

    @GetMapping("{listId}/items")
    public List<TodoItem> getAllTodoItemsInAList(@PathVariable int listId){
        return todoItemsService.getAllTodoItemsInAList(listId);
    }

    @PostMapping("/{listId}/items")
    public TodoItem createTodoItem(@PathVariable int listId, @RequestBody TodoItem todoItem){
        return todoItemsService.createTodoItem(listId, todoItem);
    }

    @PutMapping("/{listId}/items/{itemsId}")
    public TodoItem updateTodoItem(@RequestBody TodoItem todoItem, @PathVariable int listId, @PathVariable int itemsId){
        return todoItemsService.updateTodoItem(todoItem, listId, itemsId);
    }

    @DeleteMapping("/{listId}/items/{itemId}")
    public void deleteTodoItem(@PathVariable int listId, @PathVariable int itemId){
        todoItemsService.deleteTodoItem(listId, itemId);
    }

}
