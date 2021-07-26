package com.io.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.io.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Customer> query= currentSession.createQuery("from Customer", Customer.class);
		List<Customer> custlist= query.getResultList();
		System.out.println(custlist);
		return custlist;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomerById(int custId) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
        Customer c=currentSession.get(Customer.class, custId);
		return c;
	}

	@Override
	public void deleteById(int custId) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Customer> query= currentSession.createQuery("delete from Customer where id=:theid");
		query.setParameter("theid", custId);
		query.executeUpdate();
		
		
	}

}
