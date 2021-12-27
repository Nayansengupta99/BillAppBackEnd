package com.nayan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nayan.model.BillingModel;

public interface BillingRepository extends MongoRepository<BillingModel,Long>{


}
