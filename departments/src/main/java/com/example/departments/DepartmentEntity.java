package com.example.departments;

import jakarta.persistence.*;

@Entity
public class DepartmentEntity {

    // for id values starting from a certain number:
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
//    @SequenceGenerator(name = "dept_seq", sequenceName = "department_seq", initialValue = 1000, allocationSize = 1)
//   allocationSize > 1 = fetches a batch of id values; faster. allocationSize = 1 means each DB call produces an id; slower.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String departmentName;


    public DepartmentEntity() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
