package hr.demo.hrmanagement.service;

import hr.demo.hrmanagement.entity.Department;
import hr.demo.hrmanagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return departmentRepository.getAll();
    }

}
