package sky.pro.Stream.API.and.Optional;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;

    private static Employee[] employees = new Employee[MAX_EMPLOYEES];
    private static int employeeCount = 0;

    public static void addEmployee(Employee employee) {
        if (employeeCount < MAX_EMPLOYEES) {
            employees[employeeCount++] = employee;
        }
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < employeeCount; i++) {
            employeeList.add(employees[i]);
        }
        return employeeList;
    }


    public static void printAllEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }


}