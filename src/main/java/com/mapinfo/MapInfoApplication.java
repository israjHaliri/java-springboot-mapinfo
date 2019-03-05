package com.mapinfo;

import com.mapinfo.domain.User;
import com.mapinfo.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@SpringBootApplication
public class MapInfoApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(MapInfoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MapInfoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(final UserRepository userRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {

                try {
                    User user = userRepository.findByUsername("israj");
                    userRepository.delete(user.getId());

                } catch (Exception e) {
                    logger.warn("Seed user not found , it will create by default");
                }

                try {
                    User user = new User();
                    user.setUsername("israj");
                    user.setPassword(passwordEncoder.encode("12345678"));
                    user.setEnable(1);
                    user.setRole("ROLE_ADMIN");
                    userRepository.save(user);

                    logger.info("data user = {}", user.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        };

    }
}
