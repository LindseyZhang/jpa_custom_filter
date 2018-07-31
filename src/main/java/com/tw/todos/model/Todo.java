package com.tw.todos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;

/**
 * @author yangyi
 * @date 30/07/2018 4:30 PM
 */
@Entity
@Table(name = "todos")
public class Todo {
    private static int idCount = 0;

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "text")
    private String textValue;
    private boolean completed;

    public Todo(String textValue, boolean completed) {
        this.textValue = textValue;
        this.completed = completed;
    }

    public Todo() {
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

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
