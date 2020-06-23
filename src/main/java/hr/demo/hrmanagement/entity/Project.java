package hr.demo.hrmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Project {

    private Long id;

    private String title;

    private Date startDate;

    private Date endDate;

    private List<Task> taskList;

    public void addTask(Task task) {
        taskList.add(task);
    }

}
