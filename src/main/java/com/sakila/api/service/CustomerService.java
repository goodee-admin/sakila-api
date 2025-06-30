package com.sakila.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakila.api.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	private CustomerRepository customerRepository;
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
