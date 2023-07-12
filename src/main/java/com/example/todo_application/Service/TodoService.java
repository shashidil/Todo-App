package com.example.todo_application.Service;

import com.example.todo_application.Entity.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoService {
List<Todo> getTodoList ();
Todo saveTodo(Todo todo);
Todo getTodoById(long id);
Todo updateTodo(Todo todo);
void deleteById(long id);
   // void saveDate(LocalDateTime date);

}

