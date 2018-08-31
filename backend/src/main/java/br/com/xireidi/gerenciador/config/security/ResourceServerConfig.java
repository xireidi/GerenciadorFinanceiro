package br.com.xireidi.gerenciador.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/credentials/recovery", "/credentials/changePassword", "/register", "/login",
						"/portfolio/**", "/browser/**")
				.permitAll().antMatchers("/**").authenticated().antMatchers(HttpMethod.DELETE, "/users/**")
				.hasAuthority("ROLE_ADMIN");
	}

}
