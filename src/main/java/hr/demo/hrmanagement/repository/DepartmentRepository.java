package hr.demo.hrmanagement.repository;

import hr.demo.hrmanagement.entity.Department;
import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.entity.type.EmployeeStatus;
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

    public void addEmployeesToDepartment(Long depId, List<Employee> employees) {
        if(depId != null) {
            Department department = departmentMap.get(depId);
            if(department != null) {
                for(Employee employee : employees) {
                    employee.setDepartment(department);
                    addEmployeeToDepartment(depId, employee);
                    employee.setStatus(EmployeeStatus.ON_PROJECT);
                }
            }
        }
    }

    public List<Department> getAll() {
        return new ArrayList<>(departmentMap.values());
    }

}
