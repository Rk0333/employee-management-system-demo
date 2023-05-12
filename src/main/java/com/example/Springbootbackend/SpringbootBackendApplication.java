package com.example.Springbootbackend;

import com.example.Springbootbackend.model.Employee;
import com.example.Springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}


	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();
		employee.setFirstname("Rushikesh");
		employee.setLastname("Sarode");
		employee.setEmailid("rushikeshsarode30@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstname("Asshutosh");
		employee1.setLastname("Sarode");
		employee1.setEmailid("aashutoshsarode01@gmail.com");
		employeeRepository.save(employee1);


	}
}
