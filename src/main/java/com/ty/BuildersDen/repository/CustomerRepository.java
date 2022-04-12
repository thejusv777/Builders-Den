package com.ty.BuildersDen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BuildersDen.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
