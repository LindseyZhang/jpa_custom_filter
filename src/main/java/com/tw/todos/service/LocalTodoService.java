package com.tw.todos.service;

import com.tw.todos.model.Todo;
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

    @Override
    public Todo add(Todo todo) {
        todo.initId();
        todos.add(todo);
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        return todos;
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
//        两种方法都可以
//        Optional<Todo> todoOptional = todos.stream().filter(todo -> todo.getId() == id).findFirst();
//        if (!todoOptional.isPresent()) {
//            return false;
//        }
//        todoOptional.get().setText(viewTodo.getText());
//        todoOptional.get().setCompleted(viewTodo.isCompleted());
//        return true;
        Todo todoToUpdate = null;
        for (Todo todoItem : todos) {
            if (todoItem.getId() == todo.getId()) {
                todoToUpdate = todoItem;
            }
        }
        if (todoToUpdate == null) {
            return false;
        }
        todoToUpdate.setText(todo.getText());
        todoToUpdate.setCompleted(todo.isCompleted());
        return true;
    }
}
