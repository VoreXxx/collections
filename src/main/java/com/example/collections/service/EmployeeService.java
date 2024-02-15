package com.example.collections.service;

import com.example.collections.Employee;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int salary, int departmentId);

    Employee remove(String firstName, String lastName, int salary, int departmentId);

    Employee find(String firstname, String lastname);

    Collection<Employee> findAll();

    void validateNames(@NotNull String @NotNull ... names);
}
