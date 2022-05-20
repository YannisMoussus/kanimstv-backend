package kanimstv.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"kanimstv"})
@EntityScan({"kanimstv.dao.entities"})
@EnableJpaRepositories({"kanimstv.dao.repositories"})
public class SuiviStartupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuiviStartupApplication.class, args);
	}
}
