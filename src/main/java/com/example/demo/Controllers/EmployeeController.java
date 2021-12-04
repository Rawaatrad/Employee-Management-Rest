package com.example.demo.Controllers;

import com.example.demo.Entities.Employee;
import com.example.demo.Repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/


    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //create employee
    @PostMapping("/employees")
    public  Employee createEmployee(@RequestBody Employee employee){
        //employee.setPassword((bCryptPasswordEncoder.encode(employee.getPassword())));
        return employeeRepository.save(employee);
    }
    //get employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    //update employee
    @PutMapping("/employees/{id}")
    public  Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeRepository.findById(id).get();

        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        return employeeRepository.save(employee1);

    }
    //delete employee
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).get();
         employeeRepository.delete(employee);
    }


}
