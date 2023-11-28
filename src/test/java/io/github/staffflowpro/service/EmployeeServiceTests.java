package io.github.staffflowpro.service;

import io.github.staffflowpro.exception.EmployeeNotFoundException;
import io.github.staffflowpro.model.Employee;
import io.github.staffflowpro.repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTests {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddEmployee() {
        // Arrange
        Employee employeeToAdd = new Employee("John Doe", "john@example.com", "Developer", "123456789", null, null);
        when(employeeRepo.save(any(Employee.class))).thenReturn(employeeToAdd);

        // Act
        Employee addedEmployee = employeeService.addEmployee(employeeToAdd);

        // Assert
        assertNotNull(addedEmployee);
        assertEquals(employeeToAdd.getName(), addedEmployee.getName());
    }

    @Test
    void testFindAllEmployees() {
        // Arrange
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "john@example.com", "Developer", "123456789", null, null));
        employees.add(new Employee("Jane Doe", "jane@example.com", "Designer", "987654321", null, null));
        when(employeeRepo.findAll()).thenReturn(employees);

        // Act
        List<Employee> foundEmployees = employeeService.findAllEmployees();

        // Assert
        assertNotNull(foundEmployees);
        assertEquals(2, foundEmployees.size());
    }

    @Test
    void testUpdateEmployee() {
        // Arrange
        Employee employeeToUpdate = new Employee("John Doe", "john@example.com", "Developer", "123456789", null, null);
        when(employeeRepo.save(any(Employee.class))).thenReturn(employeeToUpdate);

        // Act
        Employee updatedEmployee = employeeService.updateEmployee(employeeToUpdate);

        // Assert
        assertNotNull(updatedEmployee);
        assertEquals(employeeToUpdate.getName(), updatedEmployee.getName());
    }

    @Test
    void testFindEmployeeById() {
        // Arrange
        Long id = 1L;
        Employee employee = new Employee("John Doe", "john@example.com", "Developer", "123456789", null, null);
        when(employeeRepo.findEmployeeById(id)).thenReturn(Optional.of(employee));

        // Act
        Employee foundEmployee = employeeService.findEmployeeById(id);

        // Assert
        assertNotNull(foundEmployee);
        assertEquals(employee.getName(), foundEmployee.getName());
    }

    @Test
    void testFindEmployeeById_NotFound() {
        // Arrange
        Long id = 1L;
        when(employeeRepo.findEmployeeById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployeeById(id));
    }

    @Test
    void testDeleteEmployee() {
        // Arrange
        Long id = 1L;

        // Act
        employeeService.deleteEmployee(id);

        // Assert
        verify(employeeRepo, times(1)).deleteEmployeeById(id);
    }
}
