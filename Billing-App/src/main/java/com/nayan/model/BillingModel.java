package com.nayan.model;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BILL")

public class BillingModel {

//	private int billId;
//	@OneToMany(mappedBy = "bill")
//	private List<BillDTO> list;

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	@Id

	private long id;
	private int billId;
	private float price;
	private String name;
}
