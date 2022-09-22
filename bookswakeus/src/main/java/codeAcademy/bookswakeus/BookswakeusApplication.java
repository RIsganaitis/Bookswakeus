package codeAcademy.bookswakeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:company.properties")
@ConfigurationPropertiesScan
public class BookswakeusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookswakeusApplication.class, args);
	}

}
