package com.ResourceManagement.IT.config;

import com.ResourceManagement.IT.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/signup/**").hasRole("ADMIN")
                                .requestMatchers("/api/equipment/**").hasRole("ADMIN")
                                .requestMatchers("/api/failure/**").hasRole("ADMIN")
                                .requestMatchers("/api/user/**").hasRole("ADMIN")
                                .requestMatchers("api/technician/**").hasRole("ADMIN")
                                .requestMatchers("api/ticket/update_ticket_admin").hasRole("ADMIN")
                                .requestMatchers(POST,"/api/ticket/**").hasRole("USER")
                                .requestMatchers("/api/ticket/update_ticket_technician/**").hasRole("TECHNICIAN")
                                .requestMatchers("/api/ticket/all_ticket_user_id/**").hasRole("USER")
                                .requestMatchers("/api/ticket/all_ticket_technician_id/**").hasRole("TECHNICIAN")
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin.disable())
                .addFilterBefore(new JwtAuthorizationFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
