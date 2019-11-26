package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {

	public User findByMobileNumberAndPassword(String mobileNumber, String password);

}
