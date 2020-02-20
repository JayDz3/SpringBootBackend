package com.jaydz.javaspringbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaydz.javaspringbootrest.models.Employee;
import com.jaydz.javaspringbootrest.service.DatabaseServiceImpl;


@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	DatabaseServiceImpl service;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewEmployee(@RequestParam String name, @RequestParam String role) {
		Employee e = new Employee();
		e.setName(name);
		e.setRole(role);
		service.saveEmployee(e);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		return service.getEmployees();
	}
	
	
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("jaydz");
		dataSource.setPassword("Industrial1!");
		dataSource.setUrl("jdbc:mysql://localhost:8080/javatest");
		return dataSource;
		
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPackagesToScan("com.jaydz.javaspringbootrest");
		em.setJpaVendorAdapter(adapter);
		em.setDataSource( dataSource() );
	
		return em.getObject();
		
	} */
	
	/* @Bean
	public CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			System.out.println("saving " + repository.save(new Employee("Jason Dziadosz", "Assistant Manager")));
			repository.save(new Employee("Tara Dziadosz", "Wife"));
		    System.out.println(repository.count());

		};
	} */

}
