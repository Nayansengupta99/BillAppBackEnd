package com.nayan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlRootElement
@Table(name = "BILL")
public class BillingModel {

//	private int billId;
//	@OneToMany(mappedBy = "bill")
//	private List<BillDTO> list;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int billId;
	private int price;
	private String name;
}
