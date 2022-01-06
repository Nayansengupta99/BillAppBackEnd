package com.nayan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		return "Deletion successfull for productId " + id;
	}

	public List<BillingModel> getAllBills() {
		return billingRepo.findAll();

	}


	public BillDTO getBillsById(int billId) {
		
		List<BillingModel> l = getAllBills();
		List<BillingModel> b=l.parallelStream().filter(m -> m.getBillId() == billId).collect(Collectors.toList());
		double totalcost = l.parallelStream().filter(m -> m.getBillId() == billId).mapToDouble(o -> o.getPrice()).sum();
		BillDTO d = new BillDTO(b, Double.valueOf(totalcost).floatValue());
		return d;

	}

}
