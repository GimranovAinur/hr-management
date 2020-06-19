package hr.demo.hrmanagement.entity;

import hr.demo.hrmanagement.entity.type.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Employee {

    private Long id;

    private String name;

    private String surname;

    private EmployeeStatus status;

    @ToString.Exclude
    private Department department;

    private String position;

    private String phoneNumber;

}
