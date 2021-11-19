package com.spring.config;

import com.spring.model.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/register", "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/cinema-halls", "/movies",
                        "/movie-sessions/available", "/movie-sessions/{id}").authenticated()
                .antMatchers(HttpMethod.POST, "/cinema-halls", "/movies", "/movie-sessions")
                .hasRole(RoleType.ADMIN.toString())
                .antMatchers(HttpMethod.PUT, "/movie-sessions/{id}")
                .hasRole(RoleType.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, "/movie-sessions/{id}")
                .hasRole(RoleType.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/orders", "/shopping-carts/by-user")
                .hasRole(RoleType.USER.toString())
                .antMatchers(HttpMethod.POST, "/orders/complete").hasRole(RoleType.USER.toString())
                .antMatchers(HttpMethod.PUT, "/shopping-carts/movie-sessions")
                .hasRole(RoleType.USER.toString())
                .antMatchers(HttpMethod.GET, "/users/by-email").hasRole(RoleType.ADMIN.toString())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
