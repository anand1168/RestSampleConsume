package com.selleniumexpress.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.selleniumexpress.error.AppExceptionHandler;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.selleniumexpress" })
public class MyAppConfig {

	@Bean
	public RestTemplate getRestTemplalte() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(200);
		factory.setReadTimeout(800);

		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.setErrorHandler(new AppExceptionHandler());

		return restTemplate;

	}

	@Bean
	public InternalResourceViewResolver getResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("WEB-INF/view/");
		resolver.setSuffix(".jsp");

		return resolver;

	}

}
