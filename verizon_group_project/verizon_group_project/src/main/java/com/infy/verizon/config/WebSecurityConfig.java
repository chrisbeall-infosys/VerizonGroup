package com.infy.verizon.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.infy.verizon.security.JwtAuthenticationEntryPoint;
import com.infy.verizon.security.JwtRequestFilter;
import com.infy.verizon.service.AdminServiceImpl;

// Spring boot security configuration class
//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
//	@Autowired
//	BCryptPasswordEncoder encoder;


//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	
//	@Autowired
//	private AdminServiceImpl adminService;
//	
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		// configure AuthenticationManager so that it knows from where to load
//		// user for matching credentials
//		// Use BCryptPasswordEncoder
//		
//		String encoded = encoder.encode("Password");
//		System.out.println("encoded::: "+encoded);
//		
//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder)
//		.usersByUsernameQuery("Select username, password, enabled from users where username=?")
//		.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
//		
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("Sam").password("{noop}Sam@123").roles("USER").and().withUser("Pat")
//				.password("{noop}Pat@123").roles("TRAVELER");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/**")
		.permitAll().anyRequest().authenticated();
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		// We don't need CSRF
//		
//		// Don't allow concurrent session access
//		httpSecurity.sessionManagement().maximumSessions(1)
//		 .and()
//		 .sessionAuthenticationErrorUrl("/invalidSession.html")
//		 .invalidSessionUrl("/invalidSession.html");
//		
//		httpSecurity.csrf().disable()
//					// dont authenticate this particular request
//					.authorizeRequests().antMatchers("/authenticate").permitAll()
//					// all other requests need to be authenticated
//					.anyRequest().authenticated().and()
//					// make sure we use stateless session; session won't be used to
//					// store user's state.
//					.exceptionHandling()
//					//.authenticationEntryPoint(jwtAuthenticationEntryPoint)
//					.and()
//					.formLogin()
//					.loginPage("/login")
//					.usernameParameter("username")
//					.passwordParameter("password")
//					.loginProcessingUrl("/login")
//					.defaultSuccessUrl("/adminHome", true)
//					.failureUrl("/login")
//					.permitAll()
//					.and().exceptionHandling()
//					.accessDeniedPage("/accessDenied")
//					.and().logout().logoutUrl("/logout")
//					.logoutSuccessUrl("/applicationHome")
//					.permitAll();
//				
//		// for data transfer security
//		httpSecurity.requiresChannel().anyRequest()
//		 .requiresSecure();
//
//		// Add a filter to validate the tokens with every request
//		//httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
}
