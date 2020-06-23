package hr.demo.hrmanagement.entity;

import hr.demo.hrmanagement.entity.type.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Task {

    private Long id;

    private String title;

    private Date endDate;

    private Employee producer;

    private Employee executor;

    private Project project;

    private TaskStatus status;

}
