package com.example.ToDoApp.service;

import com.example.ToDoApp.entity.TodoItem;
import com.example.ToDoApp.entity.TodoList;
import com.example.ToDoApp.repository.TodoItemRepository;
import com.example.ToDoApp.repository.TodoListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemsService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private TodoListsRepository todoListsRepository;

    public List<TodoItem> getAllTodoItemsInAList(int todoListId) {
        return todoItemRepository.findByTodoListId(todoListId);
    }


    public TodoItem createTodoItem(int listId, TodoItem todoItem) {
//        return todoItemRepository.save();
        if(todoListsRepository.findById(listId).isPresent()){
            TodoList todoList = todoListsRepository.findById(listId).get();
            todoItem.setTodolist(todoList);
            todoItem.setContent(todoItem.getContent());
            todoItem.setIs_completed(todoItem.isIs_completed());
            return todoItemRepository.save(todoItem);
        }
        else{
            return null;
        }
    }

    public TodoItem updateTodoItem(TodoItem todoItem, int listId, int itemsId) {
        if(todoListsRepository.findById(listId).isPresent()){
            TodoList todoList = todoListsRepository.findById(listId).get();
            if(todoItemRepository.findById(itemsId).isPresent()){
                todoItem.setTodolist(todoList);
                todoItem.setContent(todoItem.getContent());
                todoItem.setIs_completed(todoItem.isIs_completed());
                return todoItemRepository.save(todoItem);
            }
            else{
                return null;
            }
        }
        else{
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
