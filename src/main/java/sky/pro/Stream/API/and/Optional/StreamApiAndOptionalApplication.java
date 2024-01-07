package sky.pro.Stream.API.and.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StreamApiAndOptionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamApiAndOptionalApplication.class, args);
	}
	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService();
	}

	@Bean
	public DepartmentService departmentService(EmployeeService employeeService) {
		return new DepartmentService(employeeService);
	}

	@Bean
	public DepartmentController departmentController(DepartmentService departmentService) {
		return new DepartmentController(departmentService);
	}
}
