package com.example.todoapp.service;

import com.example.todoapp.dto.TodoItemDTO;
import com.example.todoapp.entity.TodoItem;
import com.example.todoapp.entity.TodoList;
import com.example.todoapp.repository.TodoItemRepository;
import com.example.todoapp.repository.TodoListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemsService {


    private final TodoItemRepository todoItemRepository;

    private final TodoListsRepository todoListsRepository;

    @Autowired
    public TodoItemsService(TodoItemRepository todoItemRepository, TodoListsRepository todoListsRepository){
        this.todoItemRepository = todoItemRepository;
        this.todoListsRepository = todoListsRepository;
    }

    public List<TodoItem> getAllTodoItemsInAList(int todoListId) {
        return todoItemRepository.findByTodoListId(todoListId);
    }


    public TodoItem createTodoItem(int listId, TodoItemDTO todoItemDTO) {
        TodoList todoList = todoListsRepository.findById(listId).orElseThrow();

        TodoItem todoItem = new TodoItem();
        todoItem.setContent(todoItemDTO.getContent());
        todoItem.setCompleted(todoItemDTO.isCompleted());
        todoItem.setTodolist(todoList);

        return todoItemRepository.save(todoItem);

    }

    public TodoItem updateTodoItem(TodoItemDTO todoItemDTO, int listId, int itemsId) {
        Optional<TodoList> optionalTodoList = todoListsRepository.findById(listId);

        if(optionalTodoList == null){
            return null;
        }

        Optional<TodoItem> optionalTodoItem = todoItemRepository.findById(itemsId);

        if(optionalTodoList.isPresent() && optionalTodoItem.isPresent()) {

            System.out.println("Updating TodoItem in Service Layer");
            TodoList todoList = optionalTodoList.get();
            TodoItem todoItem = optionalTodoItem.get();

            todoItem.setContent(todoItemDTO.getContent());
            todoItem.setCompleted(todoItemDTO.isCompleted());
            todoItem.setTodolist(todoList);

            return todoItemRepository.save(todoItem);
        }
        else {
            return null;
        }
    }

    public void deleteTodoItem(int listId, int itemId) {
//        todoItemRepository.deleteById();
        TodoList todoList = todoListsRepository.findById(listId).get();
        todoItemRepository.findById(itemId).get().setTodolist(null);
        todoItemRepository.deleteById(itemId);

    }

}
