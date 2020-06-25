package hr.demo.hrmanagement.repository;

import hr.demo.hrmanagement.entity.Employee;
import hr.demo.hrmanagement.entity.type.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepository {

    public Map<Long, Employee> employeeMap = new HashMap<>();

    public Long id = 0L;

    private DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        addEmployee(new Employee(id, "Иван", "Сергеев", EmployeeStatus.ON_PROJECT,
                departmentRepository.getById(0L), "Старший бухгалтер", "79164264433",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Никита", "Смирнов", EmployeeStatus.ON_PROJECT,
                departmentRepository.getById(1L), "Начальник отдела маркетинга", "79164262212",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Ирина", "Иванова", EmployeeStatus.INACTIVE,
                null, "Дизайнер", "79164234338",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Константин", "Шилов", EmployeeStatus.INACTIVE,
                null, "Маркетолог", "79164264368",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Андрей", "Саенко", EmployeeStatus.ON_PROJECT,
                departmentRepository.getById(0L), "Бухгалтер", "79164264567",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Галина", "Степаненко", EmployeeStatus.ON_PROJECT,
                departmentRepository.getById(2L), "Менеджер по продажам", "79164748923",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Павел", "Петров", EmployeeStatus.RECRUIT,
                null, "", "79164265523",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
        addEmployee(new Employee(id, "Ирина", "Матвеева", EmployeeStatus.ON_PROJECT,
                departmentRepository.getById(3L), "Менеджер кадров", "79164265523",
                "9203 472783", "644909589022", "КГАСУ Кафедра экономики и предпринимательства в строительстве", "956 454 265 49"));
    }

    public Employee getById(Long id) {
         return employeeMap.get(id);
    }

    public void addEmployee(Employee employee) {
        if(employee.getId() == null) {
            employee.setId(id);
        }
        employeeMap.put(id, employee);
        if(employee.getDepartment() != null) {
            departmentRepository.addEmployeeToDepartment(employee.getDepartment().getId(), employee);
        }
        id++;
    }

    public List<Employee> getActiveEmployees() {
        List<Employee> activeEmployees = new ArrayList<>();
        for(Employee employee: employeeMap.values()) {
            if(employee.getStatus() == EmployeeStatus.ON_PROJECT) {
                activeEmployees.add(employee);
            }
        }
        return activeEmployees;
    }

    public List<Employee> getFreeEmployees() {
        List<Employee> result = new ArrayList<>();
        for(Employee employee : employeeMap.values()) {
            if(employee.getStatus() == EmployeeStatus.INACTIVE) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeMap.values());
    }

}
