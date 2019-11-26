package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.StoreProduct;

@Repository
public interface StoreProductRepository extends JpaRepository<StoreProduct, Integer> {
	
	public List<StoreProduct> findByProductNameStartsWith(String productName);

}
