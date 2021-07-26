package com.io.dao;

import java.util.List;

import com.io.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int custId);

	public void deleteById(int custId);

}
