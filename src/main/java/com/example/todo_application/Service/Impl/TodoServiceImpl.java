package com.example.todo_application.Service.Impl;

import com.example.todo_application.Entity.Todo;
import com.example.todo_application.Repository.TodoRepository;
import com.example.todo_application.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {


    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }


    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(long id) {
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(long id) {
       todoRepository.deleteById(id);
    }
}

//    @Override
//    public void saveDate(LocalDateTime date) throws DateTimeParseException {
//        String dt = null;
//        try {
//            if (date.isBefore(LocalDate.now().atStartOfDay())) {
//                Todo todo = new Todo();
//                todo.setDate(date);
//                  dt =date.toString();
//            } else {
//                throw new DateTimeParseException("Invalid date",dt,0);
//            }
//        } catch (DateTimeParseException e) {
//            throw new DateTimeParseException("Invalid date format", dt, 0);
//        }
//        }
//
//    }

