package br.com.bycoders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.bycoders.config.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BycodersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BycodersApiApplication.class, args);
	}

}
