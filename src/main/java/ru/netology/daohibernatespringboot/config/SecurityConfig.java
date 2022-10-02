package ru.netology.daohibernatespringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("anat")
                .password("{noop}qwer1234")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeRequests()
                .antMatchers("/persons/by-city", "/persons/age-less-than").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}
