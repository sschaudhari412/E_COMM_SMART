package com.ecomsmart.backend.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/hello").permitAll() // allow frontend endpoint
                .anyRequest().authenticated() // protect other endpoints
            )
            .httpBasic(); // optional: keep basic auth
        return http.build();
    }
}

