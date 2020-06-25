package hr.demo.hrmanagement.service;

import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.entity.type.EmployeeStatus;
import hr.demo.hrmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getActiveEmployeeList() {
        return employeeRepository.getActiveEmployees();
    }

    public List<Employee> getRecruits() {
        List<Employee> employees = employeeRepository.getAll();
        List<Employee> recruits = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getStatus() == EmployeeStatus.RECRUIT
                    || employee.getStatus() == EmployeeStatus.INACTIVE) {
                recruits.add(employee);
            }
        }
        return recruits;
    }

    public List<Employee> getFreeEmployees() {
        return employeeRepository.getFreeEmployees();
    }

    public Long updateEmployee(Employee employee) {
        Employee employeeToEdit = employeeRepository.getById(employee.getId());
        employeeToEdit.setEducation(employee.getEducation());
        employeeToEdit.setINN(employee.getINN());
        employeeToEdit.setName(employee.getName());
        employeeToEdit.setSurname(employee.getSurname());
        employeeToEdit.setPassport(employee.getPassport());
        employeeToEdit.setPhoneNumber(employee.getPhoneNumber());
        employeeToEdit.setPosition(employee.getPosition());
        employeeToEdit.setSnils(employee.getSnils());

        return employeeToEdit.getDepartment().getId();
    }

}
