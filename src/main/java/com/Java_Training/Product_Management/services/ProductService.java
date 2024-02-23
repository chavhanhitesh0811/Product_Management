package com.Java_Training.Product_Management.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Java_Training.Product_Management.dto.ProductDTO;
import com.Java_Training.Product_Management.entities.Cart;
import com.Java_Training.Product_Management.entities.Product;
import com.Java_Training.Product_Management.entities.User;
import com.Java_Training.Product_Management.exceptions.InternalServerException;
import com.Java_Training.Product_Management.exceptions.InvalidProductIdException;
import com.Java_Training.Product_Management.exceptions.InvalidRquestFieldException;
import com.Java_Training.Product_Management.exceptions.NoProductFoundException;
import com.Java_Training.Product_Management.exceptions.UnauthorizedUserException;
import com.Java_Training.Product_Management.mapper.ProductMapper;
import com.Java_Training.Product_Management.repository.CartRepository;
import com.Java_Training.Product_Management.repository.ProductRepository;
import com.Java_Training.Product_Management.repository.UserRepository;
import com.Java_Training.Product_Management.utils.ProductServiceUtilityFunctions;

@Component
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	private HashMap<String, LinkedList<Integer>> map = new HashMap<>();

	public List<Product> addProduct(ProductDTO productDto, String userId)
			throws InternalServerException, InvalidRquestFieldException {

//		convert DTO to Entity
		Product product = ProductMapper.convertDtoToEntity(productDto);
		product.setEmail(userId);
		product.setDate(LocalDateTime.now());

//		saving that product to database
		Product savedProduct = productRepository.save(product);

//		uploading immage to the folder

//		Handling Exception
		if (savedProduct == null) {
			throw new InternalServerException("Something went wrong , Please try again");
		}

//		retriving the user which is processing currently
		User userProcessing = userRepository.findByEmail(userId);

//		caching implementation for least visited products
//		int userId = userProcessing.getId();
		int productId = savedProduct.getId();
		map = ProductServiceUtilityFunctions.leasetVisitedCache(map, userId, productId);

//		convert it to the list of ProductDTO
		List<Product> savedProductList = new ArrayList<Product>();
		savedProductList.add(savedProduct);

		return savedProductList;
	}

	public List<Product> getAllProducts() throws NoProductFoundException {

//		retriving all the products from database
		List<Product> products = productRepository.findByDate();

//		handling exception no record found
		if (products.size() == 0) {
			throw new NoProductFoundException("Products Not Found.");
		}

		return products;
	}

	public List<Product> getProductById(int productId, String userId) throws InvalidProductIdException {

//		retriving product from the database
		Optional<Product> product = productRepository.findById(productId);

//		Handling the exception of invalid id
		if (product.isEmpty()) {
			throw new InvalidProductIdException("Please enter a valid product id");
		}

//		caching implementation for least visited products
		map = ProductServiceUtilityFunctions.leasetVisitedCache(map, userId, productId);

		Product newProduct = product.get();

//		updating the values
		newProduct.setDate(LocalDateTime.now());

//		again save back to database
		Product savedProduct = productRepository.save(newProduct);

//		convert that into list
		List<Product> savedProductList = new ArrayList<Product>();
		savedProductList.add(product.get());

		return savedProductList;
	}

	public List<Product> updateProduct(ProductDTO productDTO, String userId, int productId)
			throws InvalidProductIdException, InternalServerException, UnauthorizedUserException {

//		convert DTO to Entity
		Product product = ProductMapper.convertDtoToEntity(productDTO);

//		retriving data from database
		Optional<Product> findById = productRepository.findById(productId);

//		Handling the exception of invalid id
		if (findById.isEmpty()) {
			throw new InvalidProductIdException("Please enter a valid product id");
		}

////		Handling the exception of unauthorized access to update the product
//		Product isAuthorizedUser = productRepository.findByIdAndEmail(productId, productDTO.getEmail());
//		if (isAuthorizedUser == null) {
//			throw new UnauthorizedUserException("You do not have access to update the particular product");
//		}

		Product newProduct = findById.get();

//		updating the values
		newProduct.setProductName(product.getProductName());
		newProduct.setBrand(product.getBrand());
		newProduct.setPrice(product.getPrice());
		newProduct.setDate(LocalDateTime.now());

//		again save back to database
		Product savedProduct = productRepository.save(newProduct);

//		Handling Exception
		if (savedProduct == null) {
			throw new InternalServerException("Failed while updating the product record , Please try again");
		}

//		caching implementation for least visited products
		map = ProductServiceUtilityFunctions.leasetVisitedCache(map, userId, productId);

//		convert that into list
		List<Product> savedProductList = new ArrayList<Product>();
		savedProductList.add(savedProduct);

		return savedProductList;
	}

	public void deleteProduct(int id) throws InvalidProductIdException, UnauthorizedUserException {

//		retriving data from database
		Optional<Product> findById = productRepository.findById(id);

//		Handling the exception of invalid id
		if (findById.isEmpty()) {
			throw new InvalidProductIdException("Please enter a valid product id");
		}

//		retriving the email from product data
//		String email = findById.get().getEmail();

//		Handling the exception of unauthorized access to update the product
//		Product isAuthorizedUser = productRepository.findByIdAndEmail(id, email);
//		if (isAuthorizedUser == null) {
//			throw new UnauthorizedUserException("You do not have access to delete the particular product");
//		}

		Product product = findById.get();

//		deleting product from database
		productRepository.delete(product);
	}

	public List<Product> listMostRecentProduct(String id) throws NoProductFoundException {

//		retriving 10 most recent visited products using native query
		List<Product> mostRecentVisited = new ArrayList<Product>();

//		handling exception no record found
		if (!map.containsKey(id)) {
			throw new NoProductFoundException("Products Not Found.");
		}

		List<Integer> list = map.get(id);

//		handling exception no record found
		if (list.size() == 0) {
			throw new NoProductFoundException("Products Not Found.");
		}

		list.forEach(productId -> {
			mostRecentVisited.add(productRepository.findById(productId).get());
		});

		return mostRecentVisited;
	}

	public List<Product> getProductByUserEmail(String userEmail) {
		List<Product> products = productRepository.findByEmail(userEmail);
		return products;
	}

	public List<Cart> addToCart(int productId, String userEmail) throws InternalServerException {

		Cart isAlereadyInserted = cartRepository.findByUserIdAndProductId(userEmail, productId);
		if (isAlereadyInserted != null) {
			return new ArrayList<Cart>();
		} else {
			Cart cart = new Cart();
			cart.setProductId(productId);
			cart.setUserId(userEmail);

			Cart savedCart = cartRepository.save(cart);

			if (savedCart == null) {
				throw new InternalServerException("Failed to add the product to cart, Please try again.");
			}

			List<Cart> savedProductToCart = new ArrayList<Cart>();
			savedProductToCart.add(savedCart);

			return savedProductToCart;
		}
	}

	public List<Product> getCartedProduct(String userId) {
		List<Product> cartedProduct = cartRepository.getCartedProduct(userId);
		return new ArrayList<Product>(cartedProduct);
	}

	public void removeFromCart(int productId, String userId) {
		Cart cart = cartRepository.findByUserIdAndProductId(userId, productId);
		cartRepository.delete(cart);
	}
}
