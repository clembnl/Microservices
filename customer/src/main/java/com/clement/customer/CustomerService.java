package com.clement.customer;

import org.springframework.stereotype.Service;

import com.clement.clients.fraud.FraudCheckResponse;
import com.clement.clients.fraud.FraudClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
	
	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		// todo: check if email valid
		// todo: check if email not taken
		customerRepository.saveAndFlush(customer);
	
		/*
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
				"http://FRAUD/api/v1/fraud-check/{customerId}", 
				FraudCheckResponse.class,
				customer.getId()
				);
		*/
		
        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());
		
		if (fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}

		// todo: send notification -> kafka
		/*
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Clement...",
                        customer.getFirstName())
        );
        */
	}


}
