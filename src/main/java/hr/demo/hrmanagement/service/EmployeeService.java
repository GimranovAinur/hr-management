package hr.demo.hrmanagement.service;

import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getActiveEmployeeList() {
        return employeeRepository.getActiveEmployees();
    }

}
