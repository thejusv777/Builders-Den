package com.ty.BuildersDen.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BuildersDen.dto.Customer;
import com.ty.BuildersDen.dto.Orders;
import com.ty.BuildersDen.repository.OrdersRepository;

@Repository
public class OrderDao {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private CustomerDao customerDao;
	
	public Orders saveOrder(int cid,Orders order) {
		Customer customer=customerDao.getCustomerById(cid);
		if(customer!=null) {
			 ordersRepository.save(order);
			 return order;
		}
		
		return null;
	}
	
	public Orders getOrdersById(int cid) {
		Optional<Orders> orders=ordersRepository.findById(cid);
		if(orders.isEmpty()) {
		   return null;
		}
		return orders.get();
	}
	
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();
	}
	
	public boolean deleteOrder(int oid) {
		Orders orders=getOrdersById(oid);
		if(orders!=null) {
			ordersRepository.deleteById(oid);
			return true;
		}
		return false;
		
	}
	
	public Orders updateOrders(int oid,Orders order) {
		Orders orders= getOrdersById(oid);
		if(orders!=null) {
			ordersRepository.save(order);
			return order;
		}
		return null;
		
	}
	
	public Orders getOrderObject() {
		return new Orders();
	}

}
