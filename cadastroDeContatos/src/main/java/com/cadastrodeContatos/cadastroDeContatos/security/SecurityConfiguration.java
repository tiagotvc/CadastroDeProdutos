package com.cadastrodeContatos.cadastroDeContatos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	private static final String[] AUTH_LIST = {
			
			"/cadastrarContatos",
			"/pessoas",
			"/{codigo}",
			"/edit/{codigo}",
			"/deletarPessoa",
			
	};

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		  auth.inMemoryAuthentication()
		  .withUser("admin").password("admin").roles("ADMIN");
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception{
		  http.csrf().disable().authorizeRequests()
		  .antMatchers(AUTH_LIST).permitAll()
		             .anyRequest().authenticated()
		      .and()
		      .httpBasic()
		      .and()
		      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  
	  }
	  
	  
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
		  return NoOpPasswordEncoder.getInstance();
		  
	  }
}
