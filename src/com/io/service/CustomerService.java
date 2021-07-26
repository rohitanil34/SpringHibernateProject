package com.io.service;

import java.util.List;

import com.io.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int custId);

	public void deleteById(int custId);


}
