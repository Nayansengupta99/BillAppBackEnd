package com.nayan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nayan.model.BillingModel;

public interface BillingRepository extends JpaRepository<BillingModel,Long>{


}
