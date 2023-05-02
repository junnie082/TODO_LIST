package com.example.todo_list.controller;

import com.example.todo_list.domain.Task;
import com.example.todo_list.repository.MemoryTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoListController {

    private final MemoryTaskRepository taskService;
    @Autowired
    public TodoListController(MemoryTaskRepository taskService) {
        this.taskService = taskService;
    }
    @GetMapping(value = "/tasks/new")
    public String createForm() {
        return "tasks/createTaskForm";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

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

    @PostMapping(value = "/tasks/new")
    public String create(TaskForm form) {
        Task task = new Task();
        task.setTask(form.getTodo());
        taskService.save(task);
        return "redirect:/";
    }

    @GetMapping(value = "/tasks")
    public String list(Model model) {
        List<Task> tasks = taskService.findAll();
        System.out.println(tasks);
        model.addAttribute("tasks", tasks);
        return "tasks/taskList";
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
