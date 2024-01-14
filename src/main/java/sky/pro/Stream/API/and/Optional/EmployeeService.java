package sky.pro.Stream.API.and.Optional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private static final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        if (employees.size() < MAX_EMPLOYEES) {
            employees.add(employee);
        }
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


}