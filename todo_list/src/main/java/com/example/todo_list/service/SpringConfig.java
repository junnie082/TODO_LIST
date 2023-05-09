package com.example.todo_list.service;

import com.example.todo_list.repository.MemoryTaskRepository;
import com.example.todo_list.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public TaskService taskService() {
        return new TaskService((MemoryTaskRepository) taskRepository());
    }
    @Bean
    public TaskRepository taskRepository() {
        return new MemoryTaskRepository();
    }
}
