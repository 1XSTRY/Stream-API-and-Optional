package sky.pro.Stream.API.and.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class streamapiandoptionalapplication {

	public static void main(String[] args) {
		SpringApplication.run(streamapiandoptionalapplication.class, args);
	}

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService();
	}

	@Bean
	public DepartmentService departmentService(EmployeeService employeeService) {
		return new DepartmentService(employeeService);
	}

	@RestController
	public class DepartmentController {
		private final DepartmentService departmentService;

		public DepartmentController(DepartmentService departmentService) {
			this.departmentService = departmentService;
		}

	}
}
