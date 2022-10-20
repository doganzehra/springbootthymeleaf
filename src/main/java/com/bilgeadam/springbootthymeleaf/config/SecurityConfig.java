package com.bilgeadam.springbootthymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig
{
	private AuthExceptionHandler handler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManagerBuilder auth) throws Exception
	{
		// post yapabilmek için csrf disable
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/ogretmen/ekle").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/").permitAll();
		http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
		// http.authorizeRequests().and().formLogin().loginPage("/giris");
		http.authorizeRequests().and().formLogin().defaultSuccessUrl("/ogretmen");
		http.authorizeRequests().and().logout().logoutSuccessUrl("/");
//		AccessDeniedHandler adh = new AccessDeniedHandler()
//		{
//			@Override
//			public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException
//			{
//				System.err.println("hataaaaaaaaaaaaaaa");
//			}
//		};
//		http.authorizeRequests().and().exceptionHandling().accessDeniedHandler(adh);
//		AuthenticationFailureHandler handler = new AuthenticationFailureHandler()
//		{
//			@Override
//			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
//			{
//				System.err.println("hataaaaaaaaaaaaaaaaaaa " + exception.getClass().getName());
//				if (exception instanceof BadCredentialsException)
//				{
//					response.sendRedirect("/sifremiunuttum");
//				}
//			}
//		};
//		http.authorizeRequests().and().formLogin().failureHandler(handler);
		http.authorizeRequests().and().formLogin().failureHandler(handler);
		return http.build();
	}
}