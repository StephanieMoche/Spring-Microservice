package com.example.employeeapp.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    // private RestTemplate restTemplate;
   // private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        // this.restTemplate = restTemplate;
        //this.employeeMapper = employeeMapper;

    }

    @GetMapping("/employees")
    public List<EmployeeDto> ListAllEmployees(){
        return employeeService.ListAllEmployees();
    }

// why is this returning a null value for the address?
    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }


    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(employeeEntity, HttpStatus.CREATED);
    }


    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("id") Long id
    ){
        employeeService.deleteEmployee(id);
    }

    // target URL for Departments microservice
    @GetMapping("/department/{departmentId}")
    public List<EmployeeResponse> getEmployeesByDepartmentId(@PathVariable Long departmentId){
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }

}



