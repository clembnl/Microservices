package com.clement.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {
	
	private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
	
	public boolean isFraudulentCustomer(Integer customerId) {
		fraudCheckHistoryRepository.save(
				FraudCheckHistory.builder()
					.customerId(customerId)
					.isFraudster(false)
					.createdAt(LocalDateTime.now())
					.build()
				);
		return false;
	}

}
