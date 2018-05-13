package lastlab.lastlabartifact;

import entity.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.GameRepository;

import java.util.Optional;

@ComponentScan({"controller", "service"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity")
public class LastlabartifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastlabartifactApplication.class, args);
	}
}
