package sky.pro.Stream.API.and.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        departmentService = new DepartmentService(employeeService);
    }

    @Test
    void testGetEmployeesByDepartment() {
        Employee employee1 = new Employee("John", 3000, 1);
        Employee employee2 = new Employee("Alice", 3500, 2);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        List<Employee> employees = departmentService.getEmployeesByDepartment(1);
        assertEquals(1, employees.size());
        assertEquals(employee1, employees.get(0));
    }

    @Test
    void testGetSalarySumByDepartment() {
        Employee employee1 = new Employee("John", 3000, 1);
        Employee employee2 = new Employee("Alice", 3500, 1);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        double sum = departmentService.getSalarySumByDepartment(1);
        assertEquals(6500, sum);
    }

    @Test
    void testGetMaxSalaryByDepartment() {
        Employee employee1 = new Employee("John", 3000, 1);
        Employee employee2 = new Employee("Alice", 3500, 1);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        double maxSalary = departmentService.getMaxSalaryByDepartment(1);
        assertEquals(3500, maxSalary);
    }

    @Test
    void testGetMinSalaryByDepartment() {
        Employee employee1 = new Employee("John", 3000, 1);
        Employee employee2 = new Employee("Alice", 3500, 1);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        double minSalary = departmentService.getMinSalaryByDepartment(1);
        assertEquals(3000, minSalary);
    }

    @Test
    void testGetAllEmployeesGroupedByDepartment() {
        Employee employee1 = new Employee("John", 3000, 1);
        Employee employee2 = new Employee("Alice", 3500, 2);
        Employee employee3 = new Employee("Bob", 3200, 1);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3));

        Map<Integer, List<Employee>> groupedEmployees = departmentService.getAllEmployeesGroupedByDepartment();
        assertEquals(2, groupedEmployees.size());
        assertEquals(2, groupedEmployees.get(1).size());
        assertEquals(1, groupedEmployees.get(2).size());
    }
}
