package com.tw.todos.service;

import com.tw.todos.model.Todo;
import com.tw.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangyi
 * @date 30/07/2018 4:25 PM
 */
@Service
public class LocalTodoService implements TodoService {

    private static List<Todo> todos = new ArrayList<>();

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo add(Todo todo) {
        todo.initId();
        todos.add(todo);
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public void clear() {
        todos.clear();
    }

    @Override
    public void delete(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    @Override
    public boolean update(Todo todo) {
        todoRepository.updateText(todo.getId(), todo.getTextValue());
        return true;
    }
}
