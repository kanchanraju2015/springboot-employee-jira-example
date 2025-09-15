package com.briz.springboot_employee_jira_example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
List<Employee> findByName(String name);
List<Employee> findByCity(String city);
}
