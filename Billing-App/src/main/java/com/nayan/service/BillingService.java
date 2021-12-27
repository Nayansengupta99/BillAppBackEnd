package com.nayan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayan.model.BillDTO;
import com.nayan.model.BillingModel;
import com.nayan.repository.BillingRepository;

@Service
public class BillingService {

	@Autowired
	private BillingRepository billingRepo;

	public BillingModel saveBill(BillingModel model) {
		return billingRepo.save(model);
	}

	public String deleteBillById(long id) {
		billingRepo.deleteById(id);
		return "Deletion successfull for billId " + id;
	}

	public List<BillingModel> getAllBills() {
		return billingRepo.findAll();

	}

	public BillDTO getBillsById(int billId) {
		List<BillingModel> l = getAllBills();

		float totalcost = 0.00f;
		List<BillingModel> b = new ArrayList<>();
		for (BillingModel m : l) {
			if (m.getBillId() == billId) {
				b.add(m);
				totalcost += m.getPrice();

			}
		}
		BillDTO d = new BillDTO(b, totalcost);

		return d;

	}

}
