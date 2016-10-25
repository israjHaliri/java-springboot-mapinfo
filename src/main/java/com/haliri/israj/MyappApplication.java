package com.haliri.israj;

import com.haliri.israj.domain.User;
import com.haliri.israj.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class MyappApplication {

	private final Logger logger = LoggerFactory.getLogger(MyappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final UserRepository userRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				User user = new User();
				user = userRepository.findByUsername("israj");

				logger.info("data user = {}",user.toString());
				if (!user.getUsername().isEmpty()){
					user.setUsername("israj");
					user.setPassword("026");
					userRepository.save(user);
				}
			}

		};

	}
}
