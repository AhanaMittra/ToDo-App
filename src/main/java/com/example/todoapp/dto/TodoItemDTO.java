package com.example.todoapp.dto;

public class TodoItemDTO {
    private int id;
    private String content;
    private boolean isCompleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        isCompleted = completed;
    }


    public TodoItemDTO() {
    }

    public TodoItemDTO(int id, String content, boolean isCompleted) {
        this.id = id;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "TodoItemDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
