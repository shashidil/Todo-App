package com.example.todo_application.Repository;

import com.example.todo_application.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
