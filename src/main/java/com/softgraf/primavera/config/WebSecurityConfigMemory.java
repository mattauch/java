package com.softgraf.primavera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfigMemory {//extends WebSecurityConfigurerAdapter {
	/*
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		//cria um usuário em memória                                                                   USER // ADMIN // ETC
		UserDetails user = User.withDefaultPasswordEncoder().username("Amanda").password("123").roles("USER").build();
		
		return new InMemoryUserDetailsManager(user);
	}
	*/

}
