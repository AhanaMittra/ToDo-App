package com.example.todoapp.service;

import com.example.todoapp.entity.TodoList;
import com.example.todoapp.repository.TodoListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListsService {

    @Autowired
    private TodoListsRepository todoListsRepository;


    public List<TodoList> getAllTodoLists() {
        return todoListsRepository.findAll();
    }

    public TodoList createTodoLists(TodoList todoList) {
        return todoListsRepository.save(todoList);
    }

    public TodoList updateTodoLists(TodoList todoList, int id) {
        if(todoListsRepository.findById(id).isPresent()){
            TodoList todoListAlreadyExist = todoListsRepository.findById(id).get();
            todoListAlreadyExist.setName(todoList.getName());
            todoListAlreadyExist.setDescription(todoList.getDescription());

            return todoListsRepository.save(todoList);
        }
        else{
            return null;
        }

    }

    public void deleteTodoList(int id) {
        todoListsRepository.deleteById(id);
    }
}
