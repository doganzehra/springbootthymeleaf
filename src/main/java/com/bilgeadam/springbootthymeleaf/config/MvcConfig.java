package com.bilgeadam.springbootthymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		// <image th:src = "user.id + '.jpg'">
		registry.addResourceHandler("*.jpg", "*.png").addResourceLocations("file:////home/kullanici/Desktop/ogretbakalim/imgs/", "classpath:/static/images/", "file:///C:/Nexon/");
		registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("*.js").addResourceLocations("classpath:/static/js/");
	}

	@Bean // (name = "SessionLocaleResolver")
	public SessionLocaleResolver localeResolver()
	{
		// CookieLocaleResolver da olabilir
		SessionLocaleResolver slr = new SessionLocaleResolver();
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		// lang şeklinde bir query parameter geldiğinde locale değişsin
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeInterceptor());
	}
}
