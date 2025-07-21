package com.arpo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arpo.models.CategoryProduct;
import com.arpo.models.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByIdCategory(CategoryProduct idCategory);

	@Query("SELECT p FROM Product p WHERE p.stock > 1")
	public Iterable<Product> loadActiveProducts();
	
	@Query("SELECT p FROM Product p JOIN p.idCategory c WHERE p.stock > 1 AND c.nameCategory = :categoryName")
	public Iterable<Product> filterProductsByCategory(@Param("categoryName") String categoryName);
}