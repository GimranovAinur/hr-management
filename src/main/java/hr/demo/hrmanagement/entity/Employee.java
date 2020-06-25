package hr.demo.hrmanagement.entity;

import hr.demo.hrmanagement.entity.type.EmployeeStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;

    private String name;

    private String surname;

    private EmployeeStatus status;

    @ToString.Exclude
    private Department department;

    private String position;

    private String phoneNumber;

    private String passport;

    private String INN;

    private String education;

    private String snils;

}
