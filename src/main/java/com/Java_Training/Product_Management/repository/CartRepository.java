package com.Java_Training.Product_Management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.Java_Training.Product_Management.entities.Cart;
import com.Java_Training.Product_Management.entities.Product;

@Component
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("SELECT p FROM Product p JOIN Cart c ON c.productId = p.id WHERE c.userId = :u")
	public List<Product> getCartedProduct(@Param("u") String email);

//	public void deleteByUserIdAndProductId(String userId, int productId);
	
	@Query("SELECT c FROM Cart c WHERE c.userId = :userId AND c.productId = :productId")
	public Cart findByUserIdAndProductId(@Param("userId") String userId, @Param("productId") int productId);

}
