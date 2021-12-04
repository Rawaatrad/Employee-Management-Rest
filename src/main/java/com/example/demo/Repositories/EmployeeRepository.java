package com.example.demo.Repositories;

import com.example.demo.Entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Long> {
    Optional<Employee> findByUsername(String username);
}
