package hr.demo.hrmanagement.entity;

import hr.demo.hrmanagement.entity.type.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDate;

    @ToString.Exclude
    private Employee producer;

    @ToString.Exclude
    private Employee executor;

    @ToString.Exclude
    private Project project;

    private TaskStatus status;

}
