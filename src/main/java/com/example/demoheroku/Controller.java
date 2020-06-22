package com.example.demoheroku;


import com.example.demoheroku.Repository.EmployeeRepository;
import com.example.demoheroku.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello   world";
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Hi " + employee.getName() + " your Registration process successfully completed";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/findEmployee/{name}")
    public List<Employee> findUser(@PathVariable String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public List<Employee> cancelRegistration(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return employeeRepository.findAll();
    }

}
