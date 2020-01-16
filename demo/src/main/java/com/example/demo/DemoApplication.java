package com.example.demo;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class DemoApplication extends WebSecurityConfigurerAdapter {
	// @Autowired
	// private OAuth2ClientContextFilter oauth2ClientContextFilter;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@GetMapping("/user")
	public Principal getUser(Principal principal) {
		return principal;
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {

		security.httpBasic().disable().authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();

	}

	/*
	 * @Bean public FilterRegistrationBean<OAuth2ClientContextFilter>
	 * oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
	 * FilterRegistrationBean<OAuth2ClientContextFilter> registration = new
	 * FilterRegistrationBean<OAuth2ClientContextFilter>();
	 * registration.setFilter(filter); registration.setOrder(-100); return
	 * registration; }
	 */

	/*
	 * @GetMapping("/foo") public String foo() { return "foo"; }
	 */

}
