package com.ty.BuildersDen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.BuildersDen.dao.OrderDao;
import com.ty.BuildersDen.dto.Orders;

@Service
public class OrderService {
	@Autowired
	OrderDao orderDao;

	public Orders saveOrder(int cid, Orders order) {
		return orderDao.saveOrder(cid, order);
	}

	public Orders getOrdersById(int cid) {
		return orderDao.getOrdersById(cid);
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
}
