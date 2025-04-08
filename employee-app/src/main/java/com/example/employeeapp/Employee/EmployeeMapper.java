package com.example.employeeapp.Employee;

import com.example.employeeapp.Address.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    private static AddressMapper addressMapper;

    public EmployeeMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }


    //GET: Entity to DTO
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(employeeEntity.getId());
        employeeDto.setFirstName(employeeEntity.getFirstName());
        employeeDto.setLastName(employeeEntity.getLastName());
        employeeDto.setEmail(employeeEntity.getEmail());
        employeeDto.setBloodGroup(employeeEntity.getBloodGroup());
        employeeDto.setDepartmentId(employeeEntity.getDepartmentId()); //added

        employeeDto.setAddress(addressMapper.entitytoDto(employeeEntity.getAddress())); //get access to the address entity table

        return employeeDto;
    }

    //POST: DTO to Entity
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDto.getId());
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setBloodGroup(employeeDto.getBloodGroup());
        employeeEntity.setDepartmentId(employeeDto.getDepartmentId()); //added

        return employeeEntity;
    }

    //GET: for the Departments
    public static EmployeeResponse EntityToResponseDto(EmployeeEntity employeeEntity) {
        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId(employeeEntity.getId());
        employeeResponse.setFirstName(employeeEntity.getFirstName());
        employeeResponse.setLastName(employeeEntity.getLastName());
        employeeResponse.setEmail(employeeEntity.getEmail());
        employeeResponse.setDepartmentId(employeeEntity.getDepartmentId()); //added

        return employeeResponse;
    }

}