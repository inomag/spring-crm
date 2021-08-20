package com.spring.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.crm.dao.CustomerDAO;
import com.spring.crm.entity.Customer;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	// INJECT DAO IN THIS CONTROLLER
	@Autowired
	private CustomerDAO customerDAO;
	@RequestMapping("list")
	public String lists(Model model) {
		
		// GET CUSTOMERS FROM DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		System.out.println(customers);
		
		// ADD CUSTOMERS TO MODEL
		model.addAttribute("customers",customers);
		
		return "customer-list";
	}

}
