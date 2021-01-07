package com.assessment.userauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.assessment.userauth.model.UserDTO;
import com.assessment.userauth.service.JwtUserDetailsService;

@EnableEurekaClient
@SpringBootApplication
public class UserAccountApplication {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
		
	public static void main(String[] args) {
		SpringApplication.run(UserAccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			UserDTO user = new UserDTO();
			user.setUsername("admin");
			user.setPassword("admin");
			userDetailsService.save(user);
		};
	}
}
