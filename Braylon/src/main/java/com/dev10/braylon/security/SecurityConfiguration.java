package com.dev10.braylon.security;

import com.dev10.braylon.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    MyUserDetailsService userDetailsService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set configuration on the auth object
        
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        
    }
    
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
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/login?login_errors=1")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .permitAll();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
