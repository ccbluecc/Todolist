package com.example.todolist.servlet;

import com.example.todolist.repositories.TodoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddTodoServlet", value = "/add-todo")
public class AddTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-todo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        if(title == null){
            req.setAttribute("error","Todo title must not be null");
        }else{
            req.setAttribute("success","New todo has been added");
            TodoRepository.addTodo(title);
        }
        req.getRequestDispatcher("/add-todo.jsp").forward(req,resp);
    }
}