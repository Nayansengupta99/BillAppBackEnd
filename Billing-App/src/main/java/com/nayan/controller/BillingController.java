package com.nayan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayan.model.BillDTO;
import com.nayan.model.BillingModel;
import com.nayan.service.BillingService;

@RestController
@RequestMapping("bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillingController {

	@Autowired
	private BillingService billService;

	@PostMapping("/save")
	public BillingModel save(@RequestBody BillingModel model) {
		return billService.saveBill(model);
	}
	
	@GetMapping("/{id}")
	public BillingModel getBillById(@PathVariable long id) {
		return billService.getBillById(id);
	}

	@GetMapping("/")
	public List<BillingModel> getAll() {
		return billService.getAllBills();
	}

	@GetMapping("/total/{billId}")
	public BillDTO getAllById(@PathVariable int billId) {
		return billService.getBillsById(billId);
	}
	@PutMapping("/update/{id}")
	public BillingModel updateBillById(@PathVariable long id,@RequestBody BillingModel model) {
        return billService.updateBillById(id, model);		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBillById(@PathVariable long id) {
		return billService.deleteBillById(id);
	}

}
