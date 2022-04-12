package com.ty.BuildersDen.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.BuildersDen.dto.Customer;
import com.ty.BuildersDen.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerById(int cid) {
		Optional<Customer> cutomer=customerRepository.findById(cid);
		if(cutomer.isEmpty()) {
		   return null;
		}
		return cutomer.get();
	}
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public boolean deleteCutomer(int cid) {
		Customer customer= getCustomerById(cid);
		if(customer!=null) {
			customerRepository.deleteById(cid);
			return true;
		}
		return false;
		
	}
	
	public Customer updateCustomer(int cid,Customer customer) {
		Customer customers= getCustomerById(cid);
		if(customers!=null) {
			customerRepository.save(customer);
			return customer;
		}
		return null;
		
	}
	
	public Customer getCustomerObject() {
		return new Customer();
	}


}
