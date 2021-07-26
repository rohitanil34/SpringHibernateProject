package com.io.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.dao.CustomerDAO;
import com.io.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer>customerList=customerDAO.getAllCustomers();

		return customerList;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int custId) {
		// TODO Auto-generated method stub
		Customer c=customerDAO.getCustomerById(custId);
		return c;
	}

	@Override
	@Transactional
	public void deleteById(int custId) {
		// TODO Auto-generated method stub
		customerDAO.deleteById(custId);
		
	}

}
