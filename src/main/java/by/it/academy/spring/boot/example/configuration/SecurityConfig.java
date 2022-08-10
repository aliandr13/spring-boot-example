package by.it.academy.spring.boot.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    // Create 2 users for demo
/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}pass").roles("USER")
                .and()
                .withUser("admin").password("{noop}pass").roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/products").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/products/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN")
                .antMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/h2-console/**").permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
*/

}
