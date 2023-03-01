package pl.ml.controller;

import org.springframework.web.bind.annotation.*;
import pl.ml.model.Task;
import pl.ml.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/{sort}")
    public List<Task> getTasks(@PathVariable String sort) {
        return taskService.findAllNotCompleted(sort);
    }
    @GetMapping("/tasks/completed/{sort}")
    public List<Task> getCompletedTasks(@PathVariable String sort) {
        return taskService.findAllCompleted(sort);
    }

    @GetMapping("/setComplete/{id}")
    public void setComplete(@PathVariable Long id) {
        Task task = taskService.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        taskService.save(task);
    }


    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.findById(id).orElseThrow();
    }

    @GetMapping("/createNewTask")
    public Task createNewTask() {
        return new Task("", "", LocalDateTime.now(), 2, false, false, null);
    }

    @GetMapping("/editTask/{id}")
    public Task editTask(@PathVariable Long id) {
        return taskService.findById(id).orElseThrow();
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        System.out.println(task.getDueDate());
        return taskService.save(task);
    }

    @PutMapping("/task/{id}")
    public Task replaceEmployee(@RequestBody Task task, @PathVariable Long id) {
        return taskService.findById(id).map(t -> {
            t.setName(task.getName());
            t.setDescription(task.getDescription());
            t.setDueDate(task.getDueDate());
            t.setCategories(task.getCategories());
            t.setPriority(task.getPriority());
            t.setCompleted(task.isCompleted());
            return taskService.save(t);
        }).orElseGet(() -> {
            task.setId(id);
            return taskService.save(task);
        });
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }

}
