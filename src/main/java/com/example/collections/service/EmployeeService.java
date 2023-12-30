package com.example.collections.service;

import com.example.collections.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstname, String lastname);

    Employee remove(String firstname, String lastname);

    Employee add(String firstName, String lastName, int salary, int departmentId);

    Employee remove(String firstName, String lastName, int salary, int departmentId);

    Employee find(String firstname, String lastname);

    Employee find(String firstName, String lastName, int salary, int departmentId);

    Collection<Employee> findAll();
}
