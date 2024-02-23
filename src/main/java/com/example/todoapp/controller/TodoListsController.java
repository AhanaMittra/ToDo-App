package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoListDTO;
import com.example.todoapp.entity.TodoList;
import com.example.todoapp.service.TodoListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListsController {

    private final TodoListsService todoListsService;

    @Autowired
    public TodoListsController(TodoListsService todoListsService) {
        this.todoListsService = todoListsService;
    }


    @GetMapping("/todolists")
    public ResponseEntity<List<TodoListDTO>> getAllTodoLists(){
        List<TodoList> todoLists = todoListsService.getAllTodoLists();
        List<TodoListDTO> todoListDTOs = todoLists.stream().map(todoList -> new TodoListDTO(todoList.getId(), todoList.getName(), todoList.getDescription())).toList();

        return ResponseEntity.ok(todoListDTOs);
    }

    @PostMapping("/todolists")
    public ResponseEntity<TodoListDTO> createTodoList(@RequestBody TodoList todoList){
        TodoList createTodoList = todoListsService.createTodoLists(todoList);

//        System.out.println(createTodoList.toString());

        if(createTodoList != null){
            TodoListDTO todoListDTO = new TodoListDTO(createTodoList.getId(), createTodoList.getName(), createTodoList.getDescription());
            System.out.println(todoListDTO.toString());
            return ResponseEntity.status(HttpStatus.CREATED).body(todoListDTO);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("todolists/{id}")
    public ResponseEntity<TodoListDTO> updateTodoList(@RequestBody TodoList todoList, @PathVariable int id){
        TodoList updatedTodoList = todoListsService.updateTodoLists(todoList, id);

        if(updatedTodoList != null){
            TodoListDTO todoListDTO = new TodoListDTO(updatedTodoList.getId(), updatedTodoList.getName(), updatedTodoList.getDescription());
            return ResponseEntity.ok(todoListDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/todolists/{id}")
    public void deleteTodoList(@PathVariable int id){
        todoListsService.deleteTodoList(id);
    }
}
