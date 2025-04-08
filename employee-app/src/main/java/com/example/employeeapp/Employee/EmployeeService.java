package com.example.employeeapp.Employee;

import com.example.employeeapp.Address.AddressEntity;
import com.example.employeeapp.Address.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;
     private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper,AddressService addressService) {
        this.employeeRepository = employeeRepository;
        this.addressService = addressService;
        this.employeeMapper = employeeMapper;
    }

    //Get all Method:
    public List<EmployeeDto> ListAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    //Get via id Method :
    public EmployeeDto getEmployee(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    //Post Method:
    public EmployeeEntity addEmployee(EmployeeDto employeeRequest) {
        EmployeeEntity employee = employeeMapper.dtoToEntity(employeeRequest);
        AddressEntity address = addressService.addAddress(employeeRequest.getAddress());
        employee.setAddress(address);
        return employeeRepository.save(employee);
    }

    //Delete Method:
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    //Get Method with dept ID:
    public List<EmployeeResponse> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId)
                .stream()
                .map(EmployeeMapper::EntityToResponseDto)
                .collect(Collectors.toList());

    }

}
