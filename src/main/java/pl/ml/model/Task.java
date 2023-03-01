package pl.ml.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime dueDate;
//    @Enumerated(EnumType.STRING)
//    private Priority priority;
    private int priority;
    private boolean completed;
    private boolean alert;

    @ManyToMany
    private Set<Category> categories;


    public Task(String name, String description, LocalDateTime dueDate, int priority, boolean completed, boolean alert, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
        this.alert = alert;
        this.categories = categories;
    }
}
