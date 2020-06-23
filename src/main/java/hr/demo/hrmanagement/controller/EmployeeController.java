package hr.demo.hrmanagement.controller;

import hr.demo.hrmanagement.service.DepartmentService;
import hr.demo.hrmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private DepartmentService departmentService;

    @GetMapping("/employees")
    public String activeEmployeeList(Model model) {
        model.addAttribute("activeEmployees", employeeService.getActiveEmployeeList());
        return "employees";
    }

    @GetMapping("/recruitment")
    public String recruitmentPage(Model model) {
        model.addAttribute("recruits", employeeService.getRecruits());
        return "recruitment";
    }

}
