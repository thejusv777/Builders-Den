package com.ty.BuildersDen.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@CreationTimestamp
	private LocalDateTime dateOfOrder;
	@UpdateTimestamp
	private LocalDateTime dateOfDelivery;
	private String message;
	private double totalCost;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@OneToMany(mappedBy = "orders")
	private List<Item> item;
	
}
