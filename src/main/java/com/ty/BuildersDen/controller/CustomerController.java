package com.ty.BuildersDen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BuildersDen.dto.Customer;
import com.ty.BuildersDen.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/customer")
	public Customer getCustomerById(@RequestParam int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/allcustomer")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomer();
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestParam int id ,@RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/customer")
	public boolean deleteCustomerById(@RequestParam int id) {
		return customerService.deleteCutomer(id);
	}
	
	@GetMapping("/emptycustomer")
	public Customer getCustomer() {
		return customerService.getCustomerObject();
	}
}
