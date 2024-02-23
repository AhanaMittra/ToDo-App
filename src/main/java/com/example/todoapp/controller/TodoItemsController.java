package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoItemDTO;
import com.example.todoapp.entity.TodoItem;
import com.example.todoapp.service.TodoItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolists")
public class TodoItemsController {

    private final TodoItemsService todoItemsService;

    @Autowired
    public TodoItemsController(TodoItemsService todoItemsService) {
        this.todoItemsService = todoItemsService;
    }

    @GetMapping("{listId}/items")
    public ResponseEntity<List<TodoItemDTO>> getAllTodoItemsInAList(@PathVariable int listId){
        List<TodoItem> todoItems = todoItemsService.getAllTodoItemsInAList(listId);
        List<TodoItemDTO> todoItemDTOs = todoItems.stream().map(todoItem -> new TodoItemDTO(todoItem.getId(), todoItem.getContent(), todoItem.isCompleted())).toList();
        return ResponseEntity.ok(todoItemDTOs);
    }

    @PostMapping("/{listId}/items")
    public ResponseEntity<TodoItemDTO> createTodoItem(@PathVariable int listId, @RequestBody TodoItemDTO todoItemDTO){
        TodoItem createTodoItem = todoItemsService.createTodoItem(listId,todoItemDTO);
        if(createTodoItem != null){
            TodoItemDTO createdTodoItemDTO = new TodoItemDTO(createTodoItem.getId(), createTodoItem.getContent(), createTodoItem.isCompleted());
            return  ResponseEntity.status(HttpStatus.CREATED).body(createdTodoItemDTO);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{listId}/items/{itemsId}")
    public ResponseEntity<TodoItemDTO> updateTodoItem(@RequestBody TodoItemDTO todoItemDTO, @PathVariable int listId, @PathVariable int itemsId){
        TodoItem updatedTodoItem = todoItemsService.updateTodoItem(todoItemDTO, listId, itemsId);
        if (updatedTodoItem != null){
            TodoItemDTO updatedTodoItemDTO = new TodoItemDTO(updatedTodoItem.getId(), updatedTodoItem.getContent(), updatedTodoItem.isCompleted());
            return  ResponseEntity.ok(updatedTodoItemDTO);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{listId}/items/{itemId}")
    public void deleteTodoItem(@PathVariable int listId, @PathVariable int itemId){
        todoItemsService.deleteTodoItem(listId, itemId);
    }

}
