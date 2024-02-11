package sky.pro.Stream.API.and.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable int id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/sum")
    public double getSalarySumByDepartment(@PathVariable int id) {
        return departmentService.getSalarySumByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/max")
    public double getMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartment(id);
    }

    @GetMapping("/department/{id}/salary/min")
    public double getMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartment(id);
    }

    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.getAllEmployeesGroupedByDepartment();
    }
}