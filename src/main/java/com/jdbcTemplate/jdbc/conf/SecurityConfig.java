package com.jdbcTemplate.jdbc.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.authorizeHttpRequests(configurer->
       configurer
       			//answerkey
    		   .requestMatchers(HttpMethod.GET, "/answerkey/v1").hasRole("USER")
    		   //studentsgrade
    		   .requestMatchers(HttpMethod.GET, "/grades/v1").hasRole("USER")
    		   .requestMatchers(HttpMethod.GET, "/grades/v1/**").hasRole("USER")
    		   .requestMatchers(HttpMethod.POST, "/grades/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.PUT, "/grades/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.DELETE, "/grades/v1/**").hasRole("ADMIN")
    		   //course
    		   .requestMatchers(HttpMethod.GET,"/course/v1").hasRole("USER")
    		   .requestMatchers(HttpMethod.POST,"/course/v1/**").hasRole("ADMIN")    
    		   .requestMatchers(HttpMethod.GET,"/course/v1/**").hasRole("USER")
    		   .requestMatchers(HttpMethod.PUT,"/course/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.DELETE,"/course/v1/**").hasRole("ADMIN")
    		   //coursesunit
    		   .requestMatchers(HttpMethod.GET,"/units/v1").hasRole("USER")
    		   .requestMatchers(HttpMethod.GET,"/units/v1/**").hasRole("USER")
    		   .requestMatchers(HttpMethod.POST,"/units/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.PUT,"/units/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.DELETE,"/units/v1/**").hasRole("ADMIN")
    		   //unittest
    		   .requestMatchers(HttpMethod.GET,"/tests/v1").hasRole("USER")
    		   .requestMatchers(HttpMethod.GET,"/tests/v1/**").hasRole("USER")
    		   .requestMatchers(HttpMethod.POST,"/tests/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.PUT,"/tests/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.DELETE,"/tests/v1/**").hasRole("ADMIN")
    		   //testquestion
    		   .requestMatchers(HttpMethod.GET,"/questions/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.GET,"/questions/v1/**").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.POST,"/questions/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.PUT,"/questions/v1").hasRole("ADMIN")
    		   .requestMatchers(HttpMethod.DELETE,"/questions/v1/**").hasRole("ADMIN")

    		   );
       //use http basic authenticaiton
       		httpSecurity.httpBasic(Customizer.withDefaults());
       		//disable cross site request forgery (csrf)
       		//in genreal, not required for staless Restapis that use post put delete patch.
       		httpSecurity.csrf(csrf->csrf.disable());
       	return  httpSecurity.build();
    }
	
	
	/*
	 * @Bean public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
	 * 
	 * UserDetails admin = User.builder() .username("admin")
	 * .password(passwordEncoder().encode("1234")) .roles("ADMIN") .build();
	 * UserDetails user= User.builder() .username("user")
	 * .password(passwordEncoder().encode("1234")) .roles("USER") .build(); return
	 * new InMemoryUserDetailsManager(admin,user); }
	 */
	  
	  @Bean public PasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder(); }
	 
	 
}