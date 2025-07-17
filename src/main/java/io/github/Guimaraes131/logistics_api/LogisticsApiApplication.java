package io.github.Guimaraes131.logistics_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LogisticsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsApiApplication.class, args);
	}

}
