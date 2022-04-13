package com.ty.BuildersDen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.BuildersDen.dto.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	@Query("Select o From Orders o Where o.customer.id=1?")
	public List<Orders> getListOfOrdersByCustomerId(int id);

}
