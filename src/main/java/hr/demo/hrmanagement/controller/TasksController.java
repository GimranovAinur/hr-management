package hr.demo.hrmanagement.controller;

import hr.demo.hrmanagement.entity.Task;
import hr.demo.hrmanagement.entity.type.TaskStatus;
import hr.demo.hrmanagement.repository.EmployeeRepository;
import hr.demo.hrmanagement.repository.ProjectRepository;
import hr.demo.hrmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskRepository.getAll());
        model.addAttribute("newTask", new Task());
        model.addAttribute("executors", employeeRepository.getActiveEmployees());
        model.addAttribute("projects", projectRepository.getAll());
        return "tasks";
    }

    @PostMapping("/new_task")
    public String newTask(@ModelAttribute Task newTask) {
        newTask.setProducer(employeeRepository.getById(1L));
        newTask.setStatus(TaskStatus.IN_PROGRESS);
        taskRepository.addTask(newTask);

        return "redirect:/tasks";
    }

}
