package com.example.todo_application.Entity;
import javax.validation.constraints.Future;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

@Entity

@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;
    @NotBlank(message = "Enter Your Activity")
    private String description;

    //@Future(message = "Date and Time should be in the future")
    @NotBlank(message = "Select Valid Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;



    public Todo() {
    }

    public Todo(long id, String userName, String description, LocalDateTime date) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
