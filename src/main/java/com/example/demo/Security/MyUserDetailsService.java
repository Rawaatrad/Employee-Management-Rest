package com.example.demo.Security;

import com.example.demo.Entities.Employee;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Employee> employee =employeeRepository.findByUsername(name);
        if (employee == null) throw new UsernameNotFoundException(name) ;
        return new User(employee.get().getUsername(),employee.get().getPassword(),new ArrayList<>());
        
    }
}
