package com.Java_Training.Product_Management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProductDTO {

	@NotEmpty(message = "Please enter a valid product name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Please enter a valid product name")
	private String productName;

	@NotEmpty(message = "Please enter a valid product brand name")
	private String brand;

	@NotNull(message = "Please enter a price of the product")
	@Min(value = 100, message = "Price of product must be atleast 100")
	private Integer price;

	@NotNull(message = "Please provide a valid image.")
	private String image;

	@NotNull(message = "Please provide a valid description.")
	private String description;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(
			@NotEmpty(message = "Please enter a valid product name") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Please enter a valid product name") String productName,
			@NotEmpty(message = "Please enter a valid product brand name") String brand,
			@NotNull(message = "Please enter a price of the product") @Min(value = 100, message = "Price of product must be atleast 100") Integer price,
			@NotNull(message = "Please provide a valid image.") String image,
			@NotNull(message = "Please provide a valid description.") String description) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.price = price;
		this.image = image;
		this.description = description;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", brand=" + brand + ", price=" + price + ", image=" + image
				+ ", description=" + description + "]";
	}

}
