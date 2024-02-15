package com.example.collections.service;

import com.example.collections.Employee;
import com.example.collections.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartmentSortedByNameSurname() {
        return employeeService
                .findAll()
                .stream()
                .sorted(comparing(Employee::getSurname).thenComparing(Employee::getName))
                .collect(groupingBy(Employee::getDepartmentId));
    }

    @Override
    public Collection<Employee> findEmployeeByDepartmentSortedByNameSurname(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(comparing(Employee::getSurname).thenComparing(Employee::getName))
                .collect(toList());
    }
}
