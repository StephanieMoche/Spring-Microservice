package com.example.departments;

//used for GET; it's separate 'cause it's getting access to external resources

import java.util.List;

public class DepartmentResponse {
    private long id;
    private String departmentName;
    private List<EmployeeDto> employees; // 'external'

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
