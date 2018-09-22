package com.lacodefy.billient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.lacodefy.billient.security.BillientAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/password_reset").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/", true)
		.failureUrl("/login?error=true")
		.failureHandler(authenticationFailureHandler())
		.and()
		.rememberMe().rememberMeParameter("remember-me")
		.and()
		.logout()
		.logoutSuccessUrl("/login?logout")
		.deleteCookies("JSESSIONID")
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new BillientAuthenticationFailureHandler();
	}

}
