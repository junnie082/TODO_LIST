package com.example.todo_list.repository;

import com.example.todo_list.domain.Task;

import java.util.*;

public class MemoryTaskRepository implements TaskRepository {

    private static Map<Long, Task> store = new HashMap<>();
    private static long priority = 0L;

    @Override
    public Task save(Task task) {
        task.setPriority(++priority);
        store.put(++priority, task);
        return task;
    }

    @Override
    public Optional<Task> findByPriority(Long priority) {
        return Optional.ofNullable(store.get(priority));
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }
}
