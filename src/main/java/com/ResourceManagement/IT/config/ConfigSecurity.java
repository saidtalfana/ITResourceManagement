package com.ResourceManagement.IT.config;


import com.ResourceManagement.IT.service.UserDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    private final UserDetailsImpl userDetailsService;

    public ConfigSecurity(UserDetailsImpl userDetailsService) {
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
//                                .requestMatchers("/api/user/**").hasRole(Roles.ROLE_ADMIN.name())
                                .requestMatchers("/save_user").permitAll()
                                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                                .requestMatchers(POST,"/api/equipment/add_equipment/**").hasRole("ADMIN")
                                .requestMatchers("/api/technician/**").hasRole("ADMIN")
                                .requestMatchers("/api/failure/**").hasRole("ADMIN")
                                .requestMatchers("/test").hasRole("USER")
                                .requestMatchers(POST,"/api/ticket/**").hasRole("USER")
                                .requestMatchers(PUT,"/api/ticket/**").hasAnyRole("TECHNICIAN","ADMIN")
                                .requestMatchers(GET,"/api/ticket/**").hasAnyRole("ADMIN","TECHNICIAN","USER")
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin.disable())
                .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()));
        http.addFilterBefore(new JwtAuthorizationFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }


}


