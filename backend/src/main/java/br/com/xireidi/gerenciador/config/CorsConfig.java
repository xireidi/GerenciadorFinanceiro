package br.com.xireidi.gerenciador.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class CorsConfig {
	private String allowOrigin = "*";

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration configAutenticacao = new CorsConfiguration();
		configAutenticacao.setAllowCredentials(true);
		configAutenticacao.addAllowedOrigin(allowOrigin);
		configAutenticacao.addAllowedHeader("Authorization");
		configAutenticacao.addAllowedHeader("Content-Type");
		configAutenticacao.addAllowedHeader("Accept");
		configAutenticacao.addAllowedMethod("OPTIONS");
		configAutenticacao.addAllowedMethod("PATCH");
		configAutenticacao.addAllowedMethod("GET");
		configAutenticacao.addAllowedMethod("POST");
		configAutenticacao.addAllowedMethod("PUT");
		configAutenticacao.addAllowedMethod("DELETE");
		configAutenticacao.setMaxAge(3600L);
		source.registerCorsConfiguration("/**", configAutenticacao);

		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new org.springframework.web.filter.CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
	}

//	@Override
//	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
//		response.addHeader("Access-Control-Allow-Origin", "http://allpereira.com.br:8080");
//		response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
//		response.addHeader("Access-Control-Allow-Headers", "Authorization, Origin, Accept, X-Requested-With, Content-Type, Accept-Encoding, Accept-Language, Connection, Host, Referer, User-Agent");
//		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
//		response.addHeader("Access-Control-Allow-Credentials", "true");
//		response.addIntHeader("Access-Control-Max-Age", 10);
//		
//		filterChain.doFilter(request, response);
//	}

}
