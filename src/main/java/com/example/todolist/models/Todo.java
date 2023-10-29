package com.example.todolist.models;

import com.example.todolist.constants.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Todo {
    private int id;
    private String title;
    private Status status;
    private static int lastid;

    public Todo(String title, Status status) {
        this.id = lastid++;
        this.title = title;
        this.status = status;
    }

    public void setStatusDone(){
        status = Status.DONE;
    }
}

