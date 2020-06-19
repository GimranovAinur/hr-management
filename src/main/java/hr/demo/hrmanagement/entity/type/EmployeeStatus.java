package hr.demo.hrmanagement.entity.type;


public enum EmployeeStatus {

    ON_PROJECT("На проекте"),

    INACTIVE("Без проекта"),

    RECRUIT("Кандидат");

    private String title;

    EmployeeStatus(String title) {
        this.title = title;
    }

}
