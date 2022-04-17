//package com.norbert.susztek.bookstore.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig2 extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		// add our users for in memory authentication
//
//		//UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication()
//
//				  .withUser("john").password("test123").roles("CUSTOMER");
//
//
//
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//				.authorizeRequests()
//				.antMatchers("/books").hasRole("CUSTOMER")
//				.antMatchers("/").permitAll()
//			.and()
//			.formLogin()
//				.loginPage("/showLoginView")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//			.and()
//			.logout()
//				.logoutSuccessUrl("/")  // after logout redirect to landing page (root)
//				.permitAll();
//	}
//}
//
//
//
//
//
//
