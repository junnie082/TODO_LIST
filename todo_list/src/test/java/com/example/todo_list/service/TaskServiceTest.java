package com.example.todo_list.service;

import com.example.todo_list.domain.Task;
import static org.assertj.core.api.Assertions.*;

import com.example.todo_list.repository.MemoryTaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    TaskService taskService;
    MemoryTaskRepository memoryTaskRepository;

    @BeforeEach
    public void beforeEach() {
        memoryTaskRepository = new MemoryTaskRepository();
        taskService = new TaskService(memoryTaskRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryTaskRepository.clearStore();
    }

    @Test
    void 할일추가() {

        // given
        Task task = new Task();
        task.setTask("read Demain");

        // when
        Long priority = taskService.add(task);

        // then
        Task findTask = taskService.findByPriority(priority).get();
        assertThat(task.getPriority()).isEqualTo(findTask.getPriority());

    }

    @Test
    void findByPriority() {
        // given
        Task task1 = new Task();
        task1.setTask("study spring");

        Task task2 = new Task();
        task2.setTask("play games");

        // when
        taskService.add(task1);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> taskService.findByPriority(4L));
        assertThat(e.getMessage()).isEqualTo("해당 우선순위가 없습니다");
//        taskService.add(task1);
//        taskService.add(task2);

//        try {
//            taskService.findByPriority(4L);
//            fail();
//        } catch(IllegalArgumentException e) {
//            assertThat(e.getMessage()).isEqualTo("해당 우선순위가 없습니다");
//        }
    }

    @Test
    void findTasks() {
    }
}