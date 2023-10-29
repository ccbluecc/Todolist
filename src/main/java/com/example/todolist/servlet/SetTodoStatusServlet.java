package com.example.todolist.servlet;

import com.example.todolist.models.Todo;
import com.example.todolist.repositories.TodoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SetTodoStatusServlet", value = "/set-todo-status")
public class SetTodoStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        if (id == null || status ==null || status.equalsIgnoreCase("done")){
            request.setAttribute("error","Invalid todo status");
        }else {
            request.getRequestDispatcher("/todo-list.jsp").forward(request,response);
        }
        Todo foundTodo = TodoRepository.findTodoById(Integer.parseInt(id));
        if(foundTodo == null){
            request.setAttribute("error", "Todo not found!");
        }else {
            foundTodo.setStatusDone();
            request.setAttribute("success","Todo moved to done successfully");
        }
        request.getRequestDispatcher("/todo-list").forward(request,response);
    }
}