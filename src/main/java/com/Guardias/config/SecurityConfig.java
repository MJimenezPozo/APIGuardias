/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Guardias.config;

import com.Guardias.jwt.JwtAuthenticationFilter;
import com.Guardias.jwt.JwtEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Fran
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    private final JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf
                        -> csrf
                        .disable())
                .authorizeHttpRequests(authRequest
                        -> authRequest
                        .requestMatchers(HttpMethod.GET, "/api/guardias/**").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/guardias/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/guardias/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/guardias/**").hasAuthority("ADMIN")
                        .requestMatchers(
                        "/auth/**", 
                        "/swagger-ui/**", 
                        "/swagger.html",
                        "/v3/api-docs/**", 
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/swagger/**",
                        "/configuration/**")
                                .permitAll()                        
                        .anyRequest().authenticated()
                        
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                    .authenticationEntryPoint(jwtEntryPoint)
                )
                .sessionManagement(sessionManager
                        -> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

}
