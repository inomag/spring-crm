package com.spring.crm.dao;

import java.util.List;

import com.spring.crm.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
