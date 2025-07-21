package com.arpo.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_supplier")
	private Long idSupplier;
	
	@Column(name = "name_supplier")
	private String nameSupplier;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;

	public Supplier(Long idSupplier, String nameSupplier, String phoneNumber, String address) {
		super();
		this.idSupplier = idSupplier;
		this.nameSupplier = nameSupplier;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public Supplier() {
		super();
	}

	public Long getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(Long idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}

	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}