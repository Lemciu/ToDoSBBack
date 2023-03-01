package pl.ml.service;

import org.springframework.stereotype.Service;
import pl.ml.model.Task;
import pl.ml.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllCompleted(String sort) {
        switch (sort) {
            case "date-desc": {
                return taskRepository.findAllByCompletedTrueOrderByDueDateDesc();
            }
            case "date-asc": {
                return taskRepository.findAllByCompletedTrueOrderByDueDate();
            }
            case "priority-asc": {
                return taskRepository.findAllByCompletedTrueOrderByPriority();

            }
            case "priority-desc": {
                return taskRepository.findAllByCompletedTrueOrderByPriorityDesc();

            }
            default: {
                return taskRepository.findAllByCompletedTrue();
            }
        }
    }

    public List<Task> findAllNotCompleted(String sort) {
        switch (sort) {
            case "date-desc": {
                return taskRepository.findAllByCompletedFalseOrderByDueDateDesc();
            }
            case "date-asc": {
                return taskRepository.findAllByCompletedFalseOrderByDueDate();
            }
            case "priority-asc": {
                return taskRepository.findAllByCompletedFalseOrderByPriority();

            }
            case "priority-desc": {
                return taskRepository.findAllByCompletedFalseOrderByPriorityDesc();

            }
            default: {
                return taskRepository.findAllByCompletedFalse();
            }
        }
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
