package sky.pro.Stream.API.and.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(int departmentId) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalary(int departmentId) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentId) {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}