package com.tw.todos.model;

/**
 * @author yangyi
 * @date 30/07/2018 4:30 PM
 */
public class Todo {
    private static int idCount = 0;

    private int id;
    private String text;
    private boolean completed;

    public Todo(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    public int initId() {
        this.id = idCount++;
        return this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
