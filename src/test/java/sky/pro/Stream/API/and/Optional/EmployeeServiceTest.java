package sky.pro.Stream.API.and.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    @Test
    void testAddEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("John Doe", 5000, 1);
        employeeService.addEmployee(employee);
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    void testRemoveEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("John Doe", 5000, 1);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(employee.getId());
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    void testGetAllEmployees() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee("John Doe", 5000, 1);
        Employee employee2 = new Employee("Jane Smith", 6000, 2);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        assertEquals(2, employeeService.getAllEmployees().size());
    }

    @Test
    void testGetAllEmployeesEmpty() {
        EmployeeService employeeService = new EmployeeService();
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    // Другие тесты на обновление сотрудника, получение сотрудника по ID и другие методы.
}
