package com.arpo.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_product")
public class CategoryProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category_product")
	private Long idCategoryProduct;
	
	@Column(name = "name_category")
	private String nameCategory;
	
	public CategoryProduct(Long idCategoryProduct, String nameCategory) {
		super();
		this.idCategoryProduct = idCategoryProduct;
		this.nameCategory = nameCategory;
	}
	
	public CategoryProduct() {
		super();
	}

	public Long getIdCategoryProduct() {
		return idCategoryProduct;
	}

	public void setIdCategoryProduct(Long idCategoryProduct) {
		this.idCategoryProduct = idCategoryProduct;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}