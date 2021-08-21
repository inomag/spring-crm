package com.spring.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// NEED TO INJECT HIBERNATE SESSION FACTORY
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// GET CURRENT HIBERNATE SESSION
		Session session = factory.getCurrentSession();
		
		// CREATE QUERY
		Query query = session.createQuery("FROM Customer", Customer.class);
		
		// GET LIST OF CUSTOMERS
		List<Customer> list = query.getResultList();
		
		// RETURN LIST OF CUSTOMERS
		return list;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(customer);
	}

}
