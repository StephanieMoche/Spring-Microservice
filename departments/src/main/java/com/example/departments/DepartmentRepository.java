package com.example.departments;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {}