package com.example.sched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.*.")
@EnableScheduling  // Enables scheduling of tasks
public class SchedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedApplication.class, args);
	}
	// Bean to allow usage of RestTemplate throughout the application
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
