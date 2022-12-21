package com.softgraf.primavera.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigJDBC extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// autoriza as requisições (faz a proteção das rotas)
		http.authorizeRequests()

				// páginas de acesso público
				.antMatchers("/", "/home/**", "/sobre", "/images/**", "/uploads/**", "/api/**").permitAll()

				// todas as outras devem ser autenticadas
				.anyRequest().authenticated()

				.and()
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/produto/gerenciar", true).permitAll())
				.logout(logout -> logout.logoutUrl("/logout"))
				// desabilita a segurança de requisições
				.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// salvar novo usuário
		//salvarNovoUsuario(auth);
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passawordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passawordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		return new JdbcUserDetailsManager(dataSource);
	}

	private void salvarNovoUsuario(AuthenticationManagerBuilder auth) throws Exception {
		UserDetails user = User.builder().username("amanda").password(passawordEncoder().encode("123456789")).roles("USER")
				.build();

		// grava o usuário no banco só uma vez! Pois na segunda lança excessão
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passawordEncoder()).withUser(user);
	}

}
