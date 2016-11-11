package com.haliri.israj.config;

//import com.haliri.israj.domain.User;
import com.haliri.israj.controller.DashboardController;
import com.haliri.israj.service.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by israjhaliri on 25/10/16.
 */

@Configuration
public class CustomSecurityConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordencoder());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                com.haliri.israj.domain.User user = userRepository.findByUsername(username);

                if(user != null) {
                    return new User(user.getUsername(), user.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
                } else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + username + "'");
                }
            }

        };
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
}
