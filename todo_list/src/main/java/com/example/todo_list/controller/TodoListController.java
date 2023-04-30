package com.example.todo_list.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoListController {

    @GetMapping("todo-mvc")
    public String todo(@RequestParam("todo_list") String todo, Model model) {
        model.addAttribute("todo_list", todo);
        return "todo";
    }

    @GetMapping("date-mvc")
    public String helloMvc(@RequestParam("date") String date, Model model) {
        model.addAttribute("date", date);
        return "hello-template";
    }

    @GetMapping("todo-string")
    @ResponseBody
    public String todoString(@RequestParam("todo") String todo) {
        return "todo: " + todo;  // "hello spring"
    }

    @GetMapping("todo-api")
    @ResponseBody
    public TODO todoApi(@RequestParam("todo") String todo_string) {
        TODO todo_hey = new TODO();
        todo_hey.setTodo(todo_string);
        return todo_hey;
    }

    static class TODO {
        private String todo;
        public String getTodo() {
            return todo;
        }
        public void setTodo(String todo) {
            this.todo = todo;
        }
    }
}
