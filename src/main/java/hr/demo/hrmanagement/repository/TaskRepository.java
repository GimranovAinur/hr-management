package hr.demo.hrmanagement.repository;

import hr.demo.hrmanagement.entity.Project;
import hr.demo.hrmanagement.entity.Task;
import hr.demo.hrmanagement.entity.type.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepository {

    private Map<Long, Task> taskMap = new HashMap<>();

    private Long id = 0L;

    private EmployeeRepository employeeRepository;

    private ProjectRepository projectRepository;

    @Autowired
    public TaskRepository(EmployeeRepository employeeRepo, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepo;
        this.projectRepository = projectRepository;
        addTask(new Task(id, "Заполнить документацию",
                new Date(), employeeRepository.getById(0L),
                employeeRepository.getById(3L), projectRepository.getById(0L), TaskStatus.IN_PROGRESS));
        addTask(new Task(id, "Провести учет",
                new Date(), employeeRepository.getById(0L),
                employeeRepository.getById(3L), projectRepository.getById(0L), TaskStatus.DONE));
        addTask(new Task(id, "Найти новых сотрудников",
                new Date(), employeeRepository.getById(3L),
                employeeRepository.getById(6L), projectRepository.getById(1L), TaskStatus.IN_PROGRESS));
        addTask(new Task(id, "Провести собеседования",
                new Date(), employeeRepository.getById(2L),
                employeeRepository.getById(6L), projectRepository.getById(1L), TaskStatus.IN_PROGRESS));
    }

    public void addTask(Task task) {
        taskMap.put(id, task);
        if(task.getProject() != null) {
            projectRepository.addProjectTask(task.getProject().getId(), task);
        }
        id++;
    }

    public List<Task> getAll() {
        return new ArrayList<>(taskMap.values());
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        List<Task> result = new ArrayList<>();
        for(Task task: taskMap.values()) {
            if(task.getProject().getId().equals(projectId)) {
                result.add(task);
            }
        }
        return result;
    }

}
