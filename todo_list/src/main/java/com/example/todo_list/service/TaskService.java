package com.example.todo_list.service;

import com.example.todo_list.domain.Task;
import com.example.todo_list.repository.MemoryTaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {

    private final MemoryTaskRepository taskRepository = new MemoryTaskRepository();

    // 할일 추가.
    public Long add(Task task) {
        taskRepository.save(task);
        return task.getPriority();
    }

    // priority 로 조회
    public Optional<Task> findByPriority(Long priority) {
        if (taskRepository.store.size() < priority) {
            throw new IllegalArgumentException("해당 우선순위가 없습니다.");
        }
        return taskRepository.findByPriority(priority);
    }

    // 전체 조회
    public List<Task> findTasks() {
        return taskRepository.findAll();
    }
}
