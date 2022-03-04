package com.clement.customer;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
//import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(
        scanBasePackages = {
                "com.clement.customer"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.clement.clients"
)
@PropertySources({
    @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	/*
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, Customer> kafkaTemplate) {
		
		Customer customer1 = Customer.builder()
			.firstName("Clement")
			.lastName("Code")
			.email("clement.code@gmail.com")
			.build();
		
		return args -> {
			kafkaTemplate.send("customer", customer1);
			System.out.println("Kafka message sent");
		};
	}
	*/

}
