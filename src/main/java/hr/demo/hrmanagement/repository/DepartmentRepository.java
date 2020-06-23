package hr.demo.hrmanagement.repository;

import hr.demo.hrmanagement.entity.Department;
import hr.demo.hrmanagement.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DepartmentRepository {

    public Long id = 0L;

    public Map<Long, Department> departmentMap = new HashMap<>();

    public DepartmentRepository() {
        addDepartment(new Department(id, "Бухгалтерия", new ArrayList<>()));
        addDepartment(new Department(id, "Маркетинг", new ArrayList<>()));
        addDepartment(new Department(id, "Отдел продаж", new ArrayList<>()));
        addDepartment(new Department(id, "Отдел кадров", new ArrayList<>()));
    }

    public Department getById(Long depId) {
        return departmentMap.get(depId);
    }

    public void addDepartment(Department department) {
        departmentMap.put(id, department);
        id++;
    }

    public void addEmployeeToDepartment(Long depId, Employee employee) {
        if(depId != null) {
            Department department = departmentMap.get(depId);
            if(department != null) {
                department.addEmployee(employee);
            }
        }
    }

    public List<Department> getAll() {
        return (List<Department>) departmentMap.values();
    }

}
