package com.example.todo_application.Controller;

import com.example.todo_application.Entity.Todo;
import com.example.todo_application.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller

public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "todos")
    public String getListTodo(Model model){
        model.addAttribute("todos",todoService.getTodoList());
        return "todos";


    }
    @GetMapping("todos/new")
    public String saveFormTodo(Model model){
        Todo todo = new Todo();
        model.addAttribute("todo",todo);
        return "create_todo";
    }
    @PostMapping("todos")
    public String saveTodo(@ModelAttribute("todo") @Valid Todo todo){
//        todoService.saveDate(todo.getDate());
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }
    @GetMapping("todos/{id}")
    public  String deleteById(@PathVariable long id){
        todoService.deleteById(id);
        return "redirect:/todos";
}
    @GetMapping("todos/edit/{id}")
    public  String editForm(@PathVariable long id, Model model){
        model.addAttribute("todo",todoService.getTodoById(id));
        return "edit_todo";
}
    @PostMapping("todos/{id}")
    public String UpdateTodo(@ModelAttribute("todo") Todo todo, @PathVariable(value = "id") long id,Model model){
        Todo existingTodo = todoService.getTodoById(id);
        //existingTodo.setId(id);
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setDate(todo.getDate());
        todoService.updateTodo(existingTodo);
        return "redirect:/todos";
    }


}






