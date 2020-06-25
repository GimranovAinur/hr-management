package hr.demo.hrmanagement.controller;

import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.entity.type.EmployeeStatus;
import hr.demo.hrmanagement.repository.EmployeeRepository;
import hr.demo.hrmanagement.service.DepartmentService;
import hr.demo.hrmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String activeEmployeeList(Model model) {
        model.addAttribute("activeEmployees", employeeService.getActiveEmployeeList());
        model.addAttribute("freeEmployees", employeeRepository.getFreeEmployees());
        return "employees";
    }

    @GetMapping("/recruitment")
    public String recruitmentPage(Model model) {
        model.addAttribute("recruits", employeeService.getRecruits());
        return "recruitment";
    }

    @GetMapping("/new_employee")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "new_employee";
    }

    @GetMapping("/interview/{empId}")
    public String setStatus(@PathVariable Long empId) {
        Employee employee = employeeRepository.getById(empId);
        employee.setStatus(EmployeeStatus.INACTIVE);

        return "redirect:/recruitment";
    }

    @PostMapping("/new_employee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employee.setStatus(EmployeeStatus.RECRUIT);
        employeeRepository.addEmployee(employee);
        return "redirect:/recruitment";
    }

    @GetMapping("/edit_employee/{empId}")
    public String editEmployee(@PathVariable Long empId, Model model) {
        Employee employee = employeeRepository.getById(empId);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/edit_employee")
    public String editEmployee(@ModelAttribute Employee employee) {
        Long depId = employeeService.updateEmployee(employee);

        return "redirect:/departments/" + depId + "/employees";
    }

}
