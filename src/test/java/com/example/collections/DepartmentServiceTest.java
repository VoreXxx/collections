package com.example.collections;

import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.service.DepartmentServiceImpl;
import com.example.collections.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.collections.EmployeeTestConstant.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(MAX_SALARY_EMPLOYEE, out.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyEmployeesList() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployeeWithMaxSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(MIN_SALARY_EMPLOYEE, out.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryInEmptyEmployeesList() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployeeWithMinSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnAllEmployeesByDepartmentWhenEmployeesExist() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(DEPARTMENT_MAP, out.findEmployeesByDepartmentSortedByNameSurname());
    }

    @Test
    public void shouldReturnEmptyMapWhenEmployeesDontExist() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyMap(), out.findEmployeesByDepartmentSortedByNameSurname());
    }

    @Test
    public void shouldReturnEmployeesByDepartmentWhenDepartmentIsCorrectAndEmployeesExistThere() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(singletonList(MIN_SALARY_EMPLOYEE
        ), out.findEmployeeByDepartmentSortedByNameSurname(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE),
                out.findEmployeeByDepartmentSortedByNameSurname(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmptyListWhenEployeesDontFoundInDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(emptyList(), out.findEmployeeByDepartmentSortedByNameSurname(BAD_DEPARTMENT_ID));
    }
}
