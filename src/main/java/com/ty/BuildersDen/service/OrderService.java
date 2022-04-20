package com.ty.BuildersDen.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.OrderDao;
import com.ty.BuildersDen.dto.Item;
import com.ty.BuildersDen.dto.Orders;
import com.ty.BuildersDen.exception.FormateMissMatchException;
import com.ty.BuildersDen.exception.IdNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	public Orders saveOrder(int cid, Orders order) {
		double totalcost = 0;
		double deliverycharge = 200;
	
		for (Item item : order.getItem()) {
			totalcost += item.getCost()*item.getQuantity();
		}
		if (totalcost <= 1000) {
			totalcost += deliverycharge;
		}
		order.setTotalCost(totalcost);
		order.setItem(order.getItem());

		Orders saveOrder = orderDao.saveOrder(cid, order);
		if (saveOrder == null) {
			throw new FormateMissMatchException();
		}
		return saveOrder;
	}

	public Orders getOrdersById(int id) {
		Orders orders = orderDao.getOrdersById(id);
		if (orders == null) {
			throw new IdNotFoundException("Given " + id + " Not Exit ");
		}
		return orders;
	}

	public List<Orders> getAllOrders() {
		return orderDao.getAllOrders();

	}

	public boolean deleteOrder(int oid) {
		return orderDao.deleteOrder(oid);
	}

	public Orders updateOrders(int oid, Orders order) {
		return orderDao.updateOrders(oid, order);
	}

	public Orders getOrderObject() {
		return orderDao.getOrderObject();
	}

	public List<Orders> getOrdersByCustomerId(int id) {

		return orderDao.getOrdersByCustomerId(id);
	}
}


