package com.example.todo_list.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoListController {

    @GetMapping("todo")
    public String todo(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
