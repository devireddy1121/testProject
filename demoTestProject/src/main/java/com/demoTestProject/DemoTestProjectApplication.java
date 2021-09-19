package com.demoTestProject;

import com.demoTestProject.dao.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDAO.class)
public class DemoTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTestProjectApplication.class, args);
	}

}
