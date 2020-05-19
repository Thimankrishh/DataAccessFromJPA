package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // save a few Employees
            repository.save(new Employee(1, "Nimal", 22));
            repository.save(new Employee(2, "Kamal", 32));
            repository.save(new Employee(3, "Roy", 21));
            repository.save(new Employee(4, "Saman", 30));
            repository.save(new Employee(5, "Kamal", 27));


            // fetch all Employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            for (Employee Employee : repository.findAll()) {
                log.info(Employee.toString());
            }
            log.info("");

            // fetch an individual Employee by ID
            Optional<Employee> Employee = repository.findById(3L);
            log.info("Employee found with findById(ID):");
            log.info("--------------------------------");
            log.info(Employee.toString());
            log.info("");

            // Using Automatic Custom Queries

            // fetch an  Employee by name
            List<Employee> EmployeeName = repository.findByName("Saman");
            log.info("Employee found with name ('name') :");
            log.info("--------------------------------");
            log.info(EmployeeName.toString());
            log.info("");

            // fetch an employee by name and age
            List<Employee> EmployeeList = repository.findByNameAndAgeGreaterThan("Kamal", 25);
            log.info("Employee found with name ('name') and age > 25 :");
            log.info("--------------------------------");
            log.info(EmployeeList.toString());
            log.info("");


            // Using Manual Custom Queries
//            List<Employee> EmployeeName = repository.findByName();
//            log.info("Employee found with name ('name') :");
//            log.info("--------------------------------");
//            log.info(EmployeeName.toString());
//            log.info("");
//
//
//            List<Employee> EmployeeList = repository.findByNameAndAgeGreaterThan();
//            log.info("Employee found with name ('name') :");
//            log.info("--------------------------------");
//            log.info(EmployeeList.toString());
//            log.info("");
        };


    }
}

