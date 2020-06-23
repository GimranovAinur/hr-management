package hr.demo.hrmanagement.controller;

import hr.demo.hrmanagement.entity.Project;
import hr.demo.hrmanagement.entity.Task;
import hr.demo.hrmanagement.entity.type.TaskStatus;
import hr.demo.hrmanagement.repository.ProjectRepository;
import hr.demo.hrmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/projects")
    public String projectsList(Model model) {
        List<Project> projectList = projectRepository.getAll();
        model.addAttribute("projects", projectList);
        Map<Long, List<Task>> projectTasks = new HashMap<>();
        Map<Long, List<Task>> tasksInProgress = new HashMap<>();
        Map<Long, List<Task>> tasksDone = new HashMap<>();
        for(Project project : projectList) {
            List<Task> tasks = taskRepository.getTasksByProjectId(project.getId());
            projectTasks.put(project.getId(), tasks);
            tasksInProgress.put(project.getId(), tasks.stream().filter(task -> task.getStatus() == TaskStatus.IN_PROGRESS).collect(Collectors.toList()));
            tasksDone.put(project.getId(), tasks.stream().filter(task -> task.getStatus() == TaskStatus.DONE).collect(Collectors.toList()));
        }
        model.addAttribute("tasksMap", projectTasks);
        model.addAttribute("tasksInProgress", tasksInProgress);
        model.addAttribute("tasksDone", tasksDone);
        return "projects";
    }

}
