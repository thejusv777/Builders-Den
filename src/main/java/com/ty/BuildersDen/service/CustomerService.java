package com.ty.BuildersDen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.CustomerDao;
import com.ty.BuildersDen.dto.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public Customer getCustomerById(int cid) {
		return customerDao.getCustomerById(cid);
	}
	
	public List<Customer> getAllCustomer(){
		return customerDao.getAllCustomer();
	}
	
	public boolean deleteCutomer(int cid) {
		return customerDao.deleteCutomer(cid);
	}
	
	public Customer updateCustomer(int cid,Customer customer) {
		return customerDao.updateCustomer(cid, customer);
	}
	
	public Customer getCustomerObject() {
		return customerDao.getCustomerObject();
	}
}
