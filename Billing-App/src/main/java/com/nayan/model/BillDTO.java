package com.nayan.model;

import java.util.List;

import lombok.Data;

@Data
public class BillDTO {

	private List<BillingModel> bills;
	private float totalPrice;

	public BillDTO(List<BillingModel> billigModel, float totalprice) {
		this.bills = billigModel;
		this.totalPrice = totalprice;

	}

}
