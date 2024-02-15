package com.example.collections;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int salary;
    private final int departmentId;

    // Constructor
    public Employee(String  firstName, String lastName, int salary, int departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    // Getter's
    public String getSurname() {
        return firstName;
    }

    public String getName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getFullName() {
        return firstName + " " + lastName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Имя " + firstName + "Фамилия " + lastName;
    }
}
