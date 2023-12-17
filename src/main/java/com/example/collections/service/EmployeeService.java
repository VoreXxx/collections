package com.example.collections.service;

import com.example.collections.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstname, String lastname);

    Employee remove(String firstname, String lastname);

    Employee find(String firstname, String lastname);

    Collection<Employee> findAll();
}
