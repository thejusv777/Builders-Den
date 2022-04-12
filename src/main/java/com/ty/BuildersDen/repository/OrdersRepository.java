package com.ty.BuildersDen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BuildersDen.dto.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
