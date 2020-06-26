package hr.demo.hrmanagement.repository;

import hr.demo.hrmanagement.entity.Department;
import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.entity.Project;
import hr.demo.hrmanagement.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ProjectRepository {

    private Long id = 0L;

    private Map<Long, Project> projectMap = new HashMap<>();

    private EmployeeRepository employeeRepository;

    @Autowired
    public ProjectRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        addProject(new Project(id, "Бухгалтерский учет", " ", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        addProject(new Project(id, "Рекрут", " ", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
    }

    public void addProject(Project project) {
        if(project.getId() == null) {
            project.setId(id);
        }
        if(project.getTaskList() == null) {
            project.setTaskList(new ArrayList<>());
        }
        projectMap.put(id, project);
        id++;
    }

    public Project getById(Long id) {
        return projectMap.get(id);
    }

    public void addProjectTask(Long projectId, Task task) {
        if(projectId != null) {
            Project project = projectMap.get(projectId);
            if(project != null) {
                project.addTask(task);
            }
        }
    }

    public List<Project> getAll() {
        return new ArrayList<>(projectMap.values());
    }

}
