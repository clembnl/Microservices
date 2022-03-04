package com.clement.fraud;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
	
	@Id
	@SequenceGenerator(
			name = "fraud_id_sequence",
			sequenceName = "faud_id_sequence"
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "fraud_id_sequence"
			)
	private Integer id;
	
	private Integer customerId;
	private boolean isFraudster;
	private LocalDateTime createdAt;

}
