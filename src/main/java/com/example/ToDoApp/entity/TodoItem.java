package com.example.ToDoApp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    private String content;

    private boolean is_completed;

    private Date created_at;

    private Date updated_at;

    public TodoItem(){

    }

    public TodoItem(int id, TodoList todolist, String content, boolean is_completed, Date created_at, Date updated_at) {
        this.id = id;
        this.todoList = todolist;
        this.content = content;
        this.is_completed = is_completed;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TodoList getTodolist() {
        return todoList;
    }

    public void setTodolist(TodoList todolist) {
        this.todoList = todolist;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", todolist=" + todoList +
                ", content='" + content + '\'' +
                ", is_completed=" + is_completed +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
