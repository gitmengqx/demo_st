package com.example.st.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author mqx
 * @date 2020-8-25 09:49:28
 */
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SpringSocialConfigurer socialConfigurer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .and()
                .apply(socialConfigurer)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        http.csrf().disable();
    }
}
