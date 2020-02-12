package com.dev10.braylon.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/home").authenticated()
                    .antMatchers("/addSalesRep", "/editSalesRep").hasRole("ADMIN")
                    .antMatchers("/salesRep").hasRole("USER")
                    .antMatchers("/customers", "/addCustomer","/editCustomer","/addSalesVisit","/addOrder").authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/home")
                    .failureUrl("/login?login_errors=1")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .permitAll();
    }
    
}
