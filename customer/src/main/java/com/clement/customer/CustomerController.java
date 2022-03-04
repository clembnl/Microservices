package com.clement.customer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="api/v1/customers")
@AllArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	private KafkaTemplate<String, Customer> kafkaTemplate;
	 
	@PostMapping("/new")
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
		log.info("new customer registration {}", customerRegistrationRequest);
		customerService.registerCustomer(customerRegistrationRequest);
		Customer customer = new Customer(customerRegistrationRequest.firstName(), 
				customerRegistrationRequest.lastName(),
				customerRegistrationRequest.email());
		System.out.println(customer.getFirstName());
		kafkaTemplate.send("clement", customer);
	}
		
}
