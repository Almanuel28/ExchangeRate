package ph.intevalue.exam.exchange.rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExchangeRateInformationExamApplication {
@Bean
public RestTemplate getRestTemplate() {
    return new RestTemplate();
}
	public static void main(String[] args) {
		SpringApplication.run(ExchangeRateInformationExamApplication.class, args);
	}

}
