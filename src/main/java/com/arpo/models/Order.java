package com.arpo.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_order") // Cambiado para evitar conflictos con "order" (palabra reservada)
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "status_order")
    private String status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_order")
	private Date dateOrder;
	
	@ManyToOne
	@JoinColumn(name = "user_order")
	private User user;

	@OneToMany(mappedBy = "order")
	private List<Cart> detalle;
	
	@Column(name = "total")
	private double total;
	
	public Order() {
		super();
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Cart> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Cart> detalle) {
		this.detalle = detalle;
	}
}