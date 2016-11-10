package com.haliri.israj.config;

import com.haliri.israj.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Israj PC on 10/18/2016.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                .antMatchers("/api/**").hasAnyRole("ADMIN").anyRequest().authenticated()
                .antMatchers("/**").permitAll().anyRequest().permitAll()
                .and()
                .httpBasic();

//        http
//                .authorizeRequests().antMatchers("/api*/**").hasRole("ADMIN").anyRequest().authenticated().and()
//                .authorizeRequests().antMatchers("*/**").permitAll().anyRequest().permitAll().and()
//                .formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll().and().csrf().disable()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
//                .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }

}
