package hr.demo.hrmanagement.util;

import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee convert(String s) {
        return employeeRepository.getById(Long.valueOf(s));
    }
}
