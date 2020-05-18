package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // Using Automatic Custom Queries
    List<Employee> findByName(String name);

    List<Employee> findByNameAndAgeGreaterThan(String name, int age);


    // Using Manual Custom Queries

    @Query(value = "SELECT e from Employee e where e.name='Saman'")
    List<Employee> findByName();

    @Query(value = "SELECT e from Employee e where e.name='Kamal' and e.age>25")
    List<Employee> findByNameAndAgeGreaterThan();

}
