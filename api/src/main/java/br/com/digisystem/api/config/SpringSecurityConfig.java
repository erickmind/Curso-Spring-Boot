package br.com.digisystem.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableGlobalMethodSecurity (prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String[] PUBLIC_ENDPOINTS = {
			"/v2/api-docs",
			"/configuration/ui",
			"/swagger-resources/**",
			"/configuration/security",
			"/swagger-ui.html",
			"/webjars/**"
	};
	
	private static final String[] PUBLIC_ENDPOINTS_GET = {
			"/produtos/**"
	};
	
	private static final String[] PUBLIC_ENDPOINTS_POST = {
		"/autenticacao", "/usuarios"	
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		
		http.cors().and().csrf().disable()
		//autoriza requisicoes que:
		.authorizeRequests()
		//todos os endpoints que estao aqui abaixo sao publicos
		.antMatchers(PUBLIC_ENDPOINTS).permitAll()
		//todos os endpoints que estao aqui abaixo sao publicos - somente metodo GET
		.antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS_GET).permitAll()
		//todos os endpoints que estao aqui abaixo sao publicos - somente metodo POST
		.antMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS_POST).permitAll()
		//Toda requisicao deve ser autenticada - usuario e senha
		.anyRequest().authenticated()
		
		//.and()
		//A excecao eh tratada aqui
		//.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		
		.and()
		//gerenciamento de sessao STATELESS
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
