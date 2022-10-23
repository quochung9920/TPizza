package com.tpizza.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tpizza.configs.handlers.LoginSuccessHandler;
import com.tpizza.configs.handlers.LogoutHandler;


@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tpizza.repository",
    "com.tpizza.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new LogoutHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password");	
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        http.formLogin().successHandler(this.loginSuccessHandler);
        http.logout().logoutSuccessHandler(this.logoutSuccessHandler);

        http.exceptionHandling().accessDeniedPage("/login?accessDenied=true");

        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_STAFF')");

        http.csrf().disable();
    }


}
