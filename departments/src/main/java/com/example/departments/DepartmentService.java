package com.example.departments;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private final WebClient webClient;
   // private final RestTemplate restTemplate;

    public DepartmentService(WebClient webClient, DepartmentRepository departmentRepository) {
        this.webClient = webClient;
        this.departmentRepository = departmentRepository;
       // this.restTemplate = restTemplate;

    }

    // POST:
    public DepartmentDto addDepartment(DepartmentDto dto) {
        DepartmentEntity department =DepartmentMapper.DtotoEntity(dto);
        DepartmentEntity savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.EntitytoDto(savedDepartment);
    }

    // GET:
    public DepartmentResponse getDepartmentWithEmployees(Long departmentId) {
        Optional<DepartmentEntity> optionalDepartment = departmentRepository.findById(departmentId);

        if (optionalDepartment.isEmpty()) {
            throw new RuntimeException("Department not found");
        }
        DepartmentEntity department = optionalDepartment.get();

        //Using Web Client:
        List<EmployeeDto> employees = webClient.get()  //starts a GET request
                .uri("http://localhost:8080/department/{departmentId}", departmentId)
                .retrieve()  //retrieves info
                .bodyToFlux(EmployeeDto.class)//for returning multiple items or a list. bodyToMono is the alternative
                .collectList()
                .block();  //wait for response first

        //Return DepartmentResponse
        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setId(department.getId());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setEmployees(employees);

        return departmentResponse;
    }


//        Using Rest Template:
//        ResponseEntity<EmployeeDto[]> response = restTemplate.getForEntity(
//                "http://localhost:8080/department/{departmentId}",
//                EmployeeDto[].class,
//                departmentId
//        );
//        List<EmployeeDto> employees = Arrays.asList(response.getBody());


}

