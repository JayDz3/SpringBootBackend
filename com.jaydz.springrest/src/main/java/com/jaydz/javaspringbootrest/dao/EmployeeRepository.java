package com.jaydz.javaspringbootrest.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaydz.javaspringbootrest.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
