package com.fitiz.fitnessmetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FitnessMetricsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessMetricsServiceApplication.class, args);
	}

}
