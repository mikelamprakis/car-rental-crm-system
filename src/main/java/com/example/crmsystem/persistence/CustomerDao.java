package com.example.crmsystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.crmsystem.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	public Customer findByNameAndAddress(
			@Param("name")String name,
			@Param("address")String address);
}

