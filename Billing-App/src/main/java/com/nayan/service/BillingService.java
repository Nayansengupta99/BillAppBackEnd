package com.nayan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayan.model.BillingModel;
import com.nayan.repository.BillingRepository;

@Service
public class BillingService {

	@Autowired
	private BillingRepository billingRepo;

	public BillingModel saveBill(BillingModel model) {

		return billingRepo.save(model);

	}
	
	public List<BillingModel> getAllBills(){
		return billingRepo.findAll();
		
	}
	
	public List<BillingModel> getBillsById(int billId){
		List<BillingModel> l=getAllBills();
		List<BillingModel> b=new ArrayList<>();
		for(BillingModel m: l) {
			if(m.getBillId()==billId) {
				b.add(m);
			}
		}
		return b;
		
	}
	
	

}