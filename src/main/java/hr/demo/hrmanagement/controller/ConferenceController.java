package hr.demo.hrmanagement.controller;

import hr.demo.hrmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConferenceController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("contacts", employeeService.getActiveEmployeeList());
        return "chat";
    }

    @GetMapping("/calls")
    public String calls(Model model) {
        model.addAttribute("contacts", employeeService.getActiveEmployeeList());
        return "calls";
    }

}
