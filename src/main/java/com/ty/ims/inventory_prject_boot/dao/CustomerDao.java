package com.ty.ims.inventory_prject_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ims.inventory_prject_boot.dto.Customer;
import com.ty.ims.inventory_prject_boot.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repository;

	public Customer saveOutward(Customer customer) {
		return repository.save(customer);
	}

	public Customer updateOutward(Customer customer) {
		return repository.save(customer);
	}

	public Optional<Customer> getOutwardById(int id) {
		return repository.findById(id);
	}

	public void deleteOutward(Customer customer) {
		repository.delete(customer);
	}
}
