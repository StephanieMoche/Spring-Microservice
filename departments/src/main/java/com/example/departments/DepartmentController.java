package com.example.departments;

import org.springframework.web.bind.annotation.*;

import java.util.List;
//this is the controller class
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentRepository departmentRepository, DepartmentService departmentService) {
        this.departmentRepository = departmentRepository;
        this.departmentService = departmentService;
    }


    @PostMapping
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }


    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentWithEmployees(@PathVariable("id") long departmentId) {
        return departmentService.getDepartmentWithEmployees(departmentId);
    }

}


