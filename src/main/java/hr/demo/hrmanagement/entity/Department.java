package hr.demo.hrmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Department {

    private Long id;

    private String title;

    List<Employee> employeeList;

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

}
