package com.example.departments;

public class DepartmentMapper {

        //GET
        public static DepartmentDto EntitytoDto(DepartmentEntity department) {
            DepartmentDto dto = new DepartmentDto();

            dto.setId(department.getId());
            dto.setDepartmentName(department.getDepartmentName());
            return dto;
        }

        //POST
        public static DepartmentEntity DtotoEntity(DepartmentDto dto) {
            DepartmentEntity department = new DepartmentEntity();

            department.setId(dto.getId());
            department.setDepartmentName(dto.getDepartmentName());

            return department;
        }
}

