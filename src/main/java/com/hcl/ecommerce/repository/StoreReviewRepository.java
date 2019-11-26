package com.hcl.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.StoreReview;

@Repository
public interface StoreReviewRepository extends JpaRepository<StoreReview, Integer> {

	public Optional<StoreReview> findByStoreId(Integer storeId);
}
