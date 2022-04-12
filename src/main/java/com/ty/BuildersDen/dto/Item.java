package com.ty.BuildersDen.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private int quantity;
	private double cost;
	@ManyToOne
	@JoinColumn
	private Vendor vendor;
	@ManyToOne
	@JoinColumn
	private Orders orders;
}
