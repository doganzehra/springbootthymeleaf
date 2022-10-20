package com.bilgeadam.springbootthymeleaf.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthExceptionHandler implements AuthenticationFailureHandler
{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
	{
		if (exception != null)
		{
			if (exception.getClass().equals(DisabledException.class))
			{
				response.sendRedirect("/login?err=2");
			}
			else if (exception.getClass().equals(BadCredentialsException.class) || exception.getClass().equals(InternalAuthenticationServiceException.class))
			{
				response.sendRedirect("/login?err=1");
			}
		}
		else
		{
			response.sendRedirect("/login?err=3");
		}
	}
}