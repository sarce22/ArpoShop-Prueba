package com.arpo.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long idProduct;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "stock_product") // Mapeo explícito y consistente
	private int stock;
	
	@Column(name = "url_imagen")
	private String urlImagen;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_category", referencedColumnName="id_category_product")
	private CategoryProduct idCategory;
	
	@ManyToOne
	@JoinColumn(name="id_supplier", referencedColumnName="id_supplier")
	private Supplier idSupplier;

	public Product() {
		super();
		this.urlImagen= "https://static.vecteezy.com/system/resources/previews/004/141/669/non_2x/no-photo-or-blank-image-icon-loading-images-or-missing-image-mark-image-not-available-or-image-coming-soon-sign-simple-nature-silhouette-in-frame-isolated-illustration-vector.jpg";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CategoryProduct getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(CategoryProduct idCategory) {
		this.idCategory = idCategory;
	}

	public Supplier getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(Supplier idSupplier) {
		this.idSupplier = idSupplier;
	}
}