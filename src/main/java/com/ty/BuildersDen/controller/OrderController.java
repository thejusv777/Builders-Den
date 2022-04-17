package com.ty.BuildersDen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BuildersDen.dto.Orders;
import com.ty.BuildersDen.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/customer/{customer_id}/vendor/{vendor_id}/order")
	public Orders saveOrder(@RequestBody Orders orders,@PathVariable int vendor_id, @PathVariable int customer_id) {
		return orderService.saveOrder(customer_id, vendor_id, orders);
	}
	
	@GetMapping("/order")
	public Orders getOrdersById(@RequestParam int vendor_id) {
		return orderService.getOrdersById(vendor_id);
	}
	
	@GetMapping("/allorder")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@PutMapping("/order")
	public Orders updateVendor(@RequestParam int id ,@RequestBody Orders orders) {
		return orderService.updateOrders(id, orders);
	}
	
	@DeleteMapping("/order")
	public boolean deleteOrdersById(@RequestParam int order_id) {
		return orderService.deleteOrder(order_id);
	}
	
	@GetMapping("/emptyorder")
	public Orders getOrders() {
		return orderService.getOrderObject();
	}
	@GetMapping("/orderlist")
	public List<Orders> getOrdersByCustomerId(@RequestParam int id){
	   return	orderService.getOrdersByCustomerId(id);
	}
	
}