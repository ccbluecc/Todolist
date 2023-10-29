package com.example.todolist.repositories;

import com.example.todolist.constants.Status;
import com.example.todolist.models.Todo;
import org.eclipse.tags.shaded.org.apache.xalan.transformer.Counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TodoRepository {
    private TodoRepository(){
    }
    private static ArrayList<Todo> todos = new ArrayList<>();
    public static Todo addTodo(String title){
        Todo newTodo = new Todo(title,Status.TODO);
        todos.add(newTodo);
        return newTodo;
    }
    public static ArrayList<Todo> findAll(){
        return todos;
    }
    public static Todo findTodoById(int id){
        return todos.get(id);
    }



}
