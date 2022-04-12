package com.ty.BuildersDen.dto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Vendor {
	private int id;
	private String name;
	private long phone;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn
	private Admin admin;
	@OneToMany(mappedBy = "vendor")
	private Item item;

}
