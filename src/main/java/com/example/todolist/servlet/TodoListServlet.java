package com.example.todolist.servlet;

import com.example.todolist.constants.Status;
import com.example.todolist.models.Todo;
import com.example.todolist.repositories.TodoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoListServlet", value = "/todo-list")
public class TodoListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Todo> todos = TodoRepository.findAll();
        List<Todo> waitingTodos = filterTodosByStatus(todos, Status.TODO);
        List<Todo> doneTodos = filterTodosByStatus(todos,Status.DONE);
        request.setAttribute("waitingTodos",waitingTodos);
        request.setAttribute("doneTodos",doneTodos);
        request.getRequestDispatcher("/todo-list.jsp").forward(request,response);
    }
    private List<Todo> filterTodosByStatus(List<Todo> todos,Status status){
        return todos.stream().filter(entry -> entry.getStatus() == status).toList();
    }
}