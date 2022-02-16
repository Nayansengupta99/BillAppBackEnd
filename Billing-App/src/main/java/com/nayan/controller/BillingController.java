package com.nayan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins ="https://makeyourownlist.herokuapp.com",maxAge = 3600)
public class BillingController {

	@Autowired
	private BillingService billService;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("Wworking Successfully", HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<BillingModel> save(@RequestBody BillingModel model) {
		return new ResponseEntity<BillingModel>(billService.saveBill(model), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BillingModel> getBillById(@PathVariable long id) {
		return new ResponseEntity<BillingModel>(billService.getBillById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<BillingModel>> getAll() {
		return new ResponseEntity<List<BillingModel>>(billService.getAllBills(), HttpStatus.OK);
	}

	@GetMapping("/total/{billId}")
	public ResponseEntity<BillDTO> getAllById(@PathVariable int billId) {
		return new ResponseEntity<BillDTO>(billService.getBillsById(billId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<BillingModel> updateBillById(@PathVariable long id, @RequestBody BillingModel model) {
		return new ResponseEntity<BillingModel>(billService.updateBillById(id, model), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBillById(@PathVariable long id) {
		return new ResponseEntity<String>(billService.deleteBillById(id), HttpStatus.OK);

	}

}
