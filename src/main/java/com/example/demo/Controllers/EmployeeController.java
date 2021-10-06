package com.example.demo.Controllers;

import com.example.demo.Entities.Employee;
import com.example.demo.Repositories.EmployeeRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //create employee
    @PostMapping
    public  Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //get employee by id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    //update employee
    @PutMapping("/{id}")
    public  Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeRepository.findById(id).get();

        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        return employeeRepository.save(employee1);


    }

}
