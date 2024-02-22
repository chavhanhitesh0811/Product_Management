package com.Java_Training.Product_Management.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String productName;

	private String brand;

	private int price;

	private LocalDateTime date;

	private String email;

	private String imageUrl;

	private String description;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String productName, String brand, int price, LocalDateTime date, String email,
			String imageUrl, String description) {
		super();
		this.id = id;
		this.productName = productName;
		this.brand = brand;
		this.price = price;
		this.date = date;
		this.email = email;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", brand=" + brand + ", price=" + price
				+ ", date=" + date + ", email=" + email + ", imageUrl=" + imageUrl + ", description=" + description
				+ "]";
	}

}
