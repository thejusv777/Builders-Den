package com.ty.BuildersDen.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	private String email;
	private String password;
	private int rating;

	@ManyToOne
	@JoinColumn
	private Admin admin;

	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	private List<Item> item;

	@JsonIgnore
	public Admin getAdmin() {
		return admin;
	}

}
