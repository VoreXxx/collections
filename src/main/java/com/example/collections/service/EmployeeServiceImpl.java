package com.example.collections.service;

import com.example.collections.Employee;
import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.exception.InvalidNameException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstname, String lastname) {
        return null;
    }

    @Override
    public Employee remove(String firstname, String lastname) {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(
                capitalize(firstName),
                capitalize(lastName),
                salary,
                departmentId
        );
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int departmentId) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int departmentId) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validateNames(@NotNull String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new InvalidNameException(name);
            }
        }
    }

    @Contract(pure = true)
    private @NotNull String getKey(String firstName, String lastName) {
        return (firstName + " " + lastName).toLowerCase();
    }
}
