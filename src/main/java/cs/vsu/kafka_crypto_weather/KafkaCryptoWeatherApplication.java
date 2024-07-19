package cs.vsu.kafka_crypto_weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class KafkaCryptoWeatherApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaCryptoWeatherApplication.class, args);
	}

}
