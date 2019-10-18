package com.fd.springbootprojects.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
				 .antMatchers("/css/**","/js/**","/views/**","/fonts/**","/images/**",
				 "/vendor/**","/webjars/**").permitAll() 	
		.anyRequest().fullyAuthenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/").failureForwardUrl("/logout").and().sessionManagement().maximumSessions(10);
		
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		List<UserDetails> users=new ArrayList();
		users.add(User.withDefaultPasswordEncoder().username("user").password("1234").roles("USER").build());
		return new InMemoryUserDetailsManager(users);
	}
	

	
}
