package pl.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ml.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByCompletedTrue();

    List<Task> findAllByCompletedFalse();

    List<Task> findAllByCompletedTrueOrderByPriorityDesc();

    List<Task> findAllByCompletedTrueOrderByPriority();

    List<Task> findAllByCompletedFalseOrderByPriorityDesc();

    List<Task> findAllByCompletedTrueOrderByDueDate();

    List<Task> findAllByCompletedFalseOrderByDueDate();

    List<Task> findAllByCompletedTrueOrderByDueDateDesc();

    List<Task> findAllByCompletedFalseOrderByDueDateDesc();

    List<Task> findAllByCompletedFalseOrderByPriority();
}
