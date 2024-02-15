package com.example.collections.controller;

import com.example.collections.Employee;
import com.example.collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int salary, @RequestParam int department) {
        return service.add(firstName, lastName, salary, department);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                   @RequestParam int salary, @RequestParam int department) {
        return service.remove(firstName, lastName, salary, department);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
