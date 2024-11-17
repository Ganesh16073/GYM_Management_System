package com.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages={"comm.model","com.controller","com.service"})
public class AppConfig {

	@Bean
	@Scope("prototype")
	public LocalDate getLocatDate()
	{
		return LocalDate.now();
	}
}
