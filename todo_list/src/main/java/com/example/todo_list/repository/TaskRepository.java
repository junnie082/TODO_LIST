package com.example.todo_list.repository;

import com.example.todo_list.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findByPriority(Long priority);
    List<Task> findAll();

    void clearStore();
}
