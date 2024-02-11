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

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public double getSalarySumByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId).stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double getMaxSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId).stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
    }

    public double getMinSalaryByDepartment(int departmentId) {
        return getEmployeesByDepartment(departmentId).stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}