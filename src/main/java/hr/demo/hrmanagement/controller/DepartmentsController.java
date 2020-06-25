package hr.demo.hrmanagement.controller;

import hr.demo.hrmanagement.entity.Department;
import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.repository.DepartmentRepository;
import hr.demo.hrmanagement.repository.EmployeeRepository;
import hr.demo.hrmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public String departments(Model model) {
        model.addAttribute("departments", departmentRepository.getAll());
        return "departments";
    }

    @GetMapping("/{depId}/employees")
    public String department(@PathVariable Long depId, Model model) {
        Department department = departmentRepository.getById(depId);
        model.addAttribute("activeEmployees", department.getEmployeeList());
        model.addAttribute("freeEmployees", employeeRepository.getFreeEmployees());
        model.addAttribute("departmentId", depId);
        return "employees";
    }

    @PostMapping("/{depId}/add_employees")
    public String addEmployees(@RequestParam Long[] employeesToAdd,
                               @PathVariable Long depId,
                               Model model) {
        List<Employee> newEmployees = new ArrayList<>();
        for(Long id : employeesToAdd) {
            newEmployees.add(employeeRepository.getById(id));
        }
        departmentRepository.addEmployeesToDepartment(depId, newEmployees);

        return "redirect:/departments/" + depId + "/employees";
    }

}
