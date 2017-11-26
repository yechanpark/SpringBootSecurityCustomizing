package ycp.practice.springsecuritycustomizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootSecruityCustomizingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecruityCustomizingApplication.class, args);
	}
}
