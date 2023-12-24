package com.example.collections;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    // Constructor
    public Employee(String surname, String name) {
        this.firstName = surname;
        this.lastName = name;
    }

    // Getter's
    public String getSurname() {
        return firstName;
    }

    public String getName() {
        return lastName;
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
