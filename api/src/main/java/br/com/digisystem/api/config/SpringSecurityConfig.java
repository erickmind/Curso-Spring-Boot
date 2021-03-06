package br.com.digisystem.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.digisystem.api.security.JWTAutenticacaoFiltro;
import br.com.digisystem.api.security.JWTAutorizacaoFiltro;
import br.com.digisystem.api.security.JWTUtil;
import br.com.digisystem.api.services.CredentialDetailsServiceImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CredentialDetailsServiceImpl userDetailsService;
		
	@Autowired
	private JWTUtil jwtUtil;
		
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	

	private static final String[] PUBLIC_ENDPOINTS = {
			"/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/produtos/**"
	};
	
	private static final String[] PUBLIC_ENDPOINTS_GET = {
			"/produtos/**", "/categorias/**"
	};

	private static final String[] PUBLIC_ENDPOINTS_POST = {
			"/auth/**"
	};
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 //http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		 
		 http.cors().and().csrf().disable()
 		//autoriza requisi????es que: 
         .authorizeRequests()
         //todos os endpoints que est??p aqui abaixo s??o p??blicos
         .antMatchers(PUBLIC_ENDPOINTS).permitAll()                
         //todos os endpoints que est??p aqui abaixo s??o p??blicos - somente m??todo GET
         .antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS_GET).permitAll()                
         //todos os endpoints que est??p aqui abaixo s??o p??blicos - somente m??todo POST
         .antMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS_POST).permitAll()                
         //Toda requisi????o deve ser autenticada - usu??rio e senha
         .anyRequest().authenticated()
         
         //.and()
         //A exce????o ?? tratada aqui
         //.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
         
         .and()
         //gerenciamenteo de sess??o STATELESS
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 /* adicionado o filtro de autentica????o*/
		 http.addFilter(new JWTAutenticacaoFiltro(authenticationManager(), jwtUtil));
		 http.addFilter(new JWTAutorizacaoFiltro(authenticationManager(), jwtUtil, userDetailsService));
		 		 
	 }

}
