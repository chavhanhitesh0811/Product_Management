package com.Java_Training.Product_Management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.Java_Training.Product_Management.entities.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p FROM Product p WHERE email =:e ORDER BY date DESC LIMIT 10")
	public List<Product> mostRecentVisited(@Param("e") String email);
	
	public Product findByIdAndEmail(int id , String Email);
	
	public List<Product> findByEmail(String email);
	
	@Query("select p FROM Product p ORDER BY date DESC")
	public List<Product> findByDate();
}
