package com.example.demo.security;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    Dotenv dotenv = Dotenv.configure().load();

    String username = dotenv.get("USER_LOGIN");
    String password= dotenv.get("PASSWORD_LOGIN");
    String role = dotenv.get("USER_ROLE");

    String admin = dotenv.get("ADMIN_LOGIN");
    String adminPassword = dotenv.get("ADMIN_PASSWORD");
    String adminRole = dotenv.get("ADMIN_ROLE");


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/index/rawDataFromDatabase").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(role)
                .build();
        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username(admin)
                .password(adminPassword)
                .roles(adminRole)
                .build();

        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }
}
