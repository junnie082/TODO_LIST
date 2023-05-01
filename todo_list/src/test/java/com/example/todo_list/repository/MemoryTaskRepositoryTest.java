package com.example.todo_list.repository;

import com.example.todo_list.domain.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryTaskRepositoryTest {

    TaskRepository repository = new MemoryTaskRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Task task = new Task();
        task.setTask("Study Java Spring");

        repository.save(task);

        //assertThat(task.getPriority()).isEqualTo(1L);
        Task result = repository.findByPriority(task.getPriority()).get();
        assertThat(task).isEqualTo(result);
    }

    @Test
    public void findByPriority() {
        Task task1 = new Task();
        task1.setPriority(1L);
        repository.save(task1);

        Task task2 = new Task();
        task2.setPriority(2L);
        repository.save(task2);

        Task result = repository.findByPriority(1L).get();

        assertThat(result).isEqualTo(task1);
    }

    @Test
    public void findAll() {
        Task task1 = new Task();
        task1.setPriority(1L);
        repository.save(task1);

        Task task2 = new Task();
        task2.setPriority(2L);
        repository.save(task2);

        List<Task> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
