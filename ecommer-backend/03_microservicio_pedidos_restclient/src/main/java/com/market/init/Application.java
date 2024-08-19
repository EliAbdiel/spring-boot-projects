package com.market.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.market.model")
@EnableJpaRepositories(basePackages = "com.market.repository")
@SpringBootApplication(scanBasePackages = {"com.market.service","com.market.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestClient getClient() {
		return RestClient.create();
	}

}
