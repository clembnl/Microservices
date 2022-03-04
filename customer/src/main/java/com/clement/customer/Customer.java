package com.clement.customer;

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
public class Customer {
	
	@Id
	@SequenceGenerator(
			name = "customer_id_sequence",
			sequenceName = "customer_id_sequence"
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_id_sequence"
			)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String email;
	
	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}
