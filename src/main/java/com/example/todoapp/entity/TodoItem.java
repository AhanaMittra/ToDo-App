package com.example.todoapp.entity;

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

    private boolean isCompleted;

    private Date createdAt;

    private Date updatedAt;

    public TodoItem(){

    }

    public TodoItem(int id, TodoList todolist, String content, boolean isCompleted, Date createdAt, Date updatedAt) {
        this.id = id;
        this.todoList = todolist;
        this.content = content;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", todolist=" + todoList +
                ", content='" + content + '\'' +
                ", is_completed=" + isCompleted +
                ", created_at=" + createdAt +
                ", updated_at=" + updatedAt +
                '}';
    }
}
