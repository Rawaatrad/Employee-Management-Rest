package com.example.demo.Controllers;

import com.example.demo.Entities.Employee;
import com.example.demo.Repositories.EmployeeRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
