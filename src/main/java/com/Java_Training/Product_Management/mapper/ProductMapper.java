package com.Java_Training.Product_Management.mapper;

import com.Java_Training.Product_Management.dto.ProductDTO;
import com.Java_Training.Product_Management.entities.Product;

public class ProductMapper {

	public static Product convertDtoToEntity(ProductDTO productDTO) {

		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setBrand(productDTO.getBrand());
		product.setPrice(productDTO.getPrice());
		product.setImageUrl(productDTO.getImage());
		product.setDescription(productDTO.getDescription());

		return product;
	}

	public static ProductDTO convertEntityToDto(Product product) {

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(product.getProductName());
		productDTO.setBrand(product.getBrand());
		productDTO.setPrice(product.getPrice());
		productDTO.setImage(product.getImageUrl());
		productDTO.setDescription(product.getDescription());
		
		return productDTO;
	}
}
