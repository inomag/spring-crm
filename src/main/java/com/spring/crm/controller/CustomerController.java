package com.spring.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.crm.dao.CustomerDAO;
import com.spring.crm.entity.Customer;
import com.spring.crm.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	// INJECT DAO IN THIS CONTROLLER
//	@Autowired
//	private CustomerDAO customerDAO;
	
	
	// USING CUSTOMER SERVICE
	@Autowired
	private CustomerService service;
	
	@GetMapping("list")
	public String lists(Model model) {
		// GET CUSTOMERS FROM DAO
//		List<Customer> customers = customerDAO.getCustomers();
		// GET CUSTOMERS FROM SERVICE
		List<Customer> customers = service.getCustomers();
		System.out.println(customers);
		// ADD CUSTOMERS TO MODEL
		model.addAttribute("customers",customers);
		return "customer-list";
	}
	
	@GetMapping("add")
	public String showFormForAdd(Model model) {
		// Create object
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		
		return "customer-form";
	}

}
