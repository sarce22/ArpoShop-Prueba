package com.arpo.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user") // Cambiado de "user" a "app_user" para evitar palabra reservada
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_user") // Mapeo explícito
	private Long idUser;
	
	@Column(name = "name_user") // Mapeo explícito
	private String name;
	
	@Column(name = "surname_user") // Mapeo explícito
	private String surname;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
	private Rol idRol;

	@OneToMany(mappedBy = "user")
	private List<Product> productos;
	
	@OneToMany(mappedBy = "user")
	private List<Order> ordenes;
	
	public User(Long idUser, String name, String surname, int age, String email,
			String password, String address, String phoneNumber, Rol idRol) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.idRol = idRol;
	}
	
	public User() {
		super();
	}

	// Getters y setters (sin cambios)
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	public List<Order> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Order> ordenes) {
		this.ordenes = ordenes;
	}
}