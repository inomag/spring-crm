package com.spring.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("save")
	public String saveCustomer(@ModelAttribute("cutomer")Customer customer) {
		// SAVE CUSTOMER USING SERVICE
		service.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("update")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {
	
		// get the customer from our service
		Customer theCustomer = service.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("delete")
	public String deleteUser(@RequestParam("customerId") int theId,
			Model theModel) {
	
		// delete the customer from our service
		service.deleteCustomer(theId);	
	
		
		// send over to our form		
		return "redirect:/customer/list";
	}
	
	

}
