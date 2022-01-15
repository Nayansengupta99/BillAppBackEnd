package com.nayan.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.nayan.model.BillDTO;
import com.nayan.model.BillingModel;
import com.nayan.model.DatabaseSequence;
import com.nayan.repository.BillingRepository;

@Service
public class BillingService {

	@Autowired
	private BillingRepository billingRepo;
	@Autowired
	private MongoOperations mongoOperations;

	public long generateSequence(String seqName) {

		DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	public BillingModel saveBill(BillingModel model) {
		model.setId(generateSequence(BillingModel.SEQUENCE_NAME));
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
		List<BillingModel> b = l.parallelStream().filter(m -> m.getBillId() == billId).collect(Collectors.toList());
		double totalcost = l.parallelStream().filter(m -> m.getBillId() == billId).mapToDouble(o -> o.getPrice()).sum();
		BillDTO d = new BillDTO(b, Double.valueOf(totalcost).floatValue());
		return d;

	}
	
	public BillingModel updateBillById(long id,BillingModel model) {
		BillingModel m=billingRepo.findById(id).get();
		
		if(model!=null) {
			m.setBillId(model.getBillId());
			m.setName(model.getName());
			m.setPrice(model.getPrice());
			
		}
		return billingRepo.save(m);
		
		
	}
	
	public BillingModel getBillById(long id) {
		return billingRepo.findById(id).get();
	}

}
