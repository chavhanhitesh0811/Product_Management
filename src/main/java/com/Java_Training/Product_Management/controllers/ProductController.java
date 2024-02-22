package com.Java_Training.Product_Management.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Java_Training.Product_Management.dto.ProductDTO;
import com.Java_Training.Product_Management.entities.Product;
import com.Java_Training.Product_Management.exceptions.InternalServerException;
import com.Java_Training.Product_Management.exceptions.InvalidProductIdException;
import com.Java_Training.Product_Management.exceptions.InvalidRquestFieldException;
import com.Java_Training.Product_Management.exceptions.NoProductFoundException;
import com.Java_Training.Product_Management.exceptions.UnauthorizedUserException;
import com.Java_Training.Product_Management.services.ProductService;
import com.Java_Training.Product_Management.utils.SuccessResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "Keycloak")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody ProductDTO productDto, Principal user)
			throws InternalServerException, InvalidRquestFieldException {
		System.err.println(productDto);
		List<Product> savedProduct = productService.addProduct(productDto, user.getName());
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, "SUCCESS",
				"Product Inserted Successfully.", new ArrayList<Object>(savedProduct)));
	}

	@GetMapping("/product")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> getAllProducts(HttpServletRequest request)
			throws NoProductFoundException, UnauthorizedUserException {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, "SUCCESS",
				"Products Retrived Successfully.", new ArrayList<Object>(products)));
	}

	@GetMapping("/product/{productId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> getProductById(@PathVariable("productId") int productId, Principal user)
			throws InvalidProductIdException {
		List<Product> product = productService.getProductById(productId, user.getName());
		return ResponseEntity.status(HttpStatus.OK).body(
				new SuccessResponse(200, "SUCCESS", "Product Retrived Successfully.", new ArrayList<Object>(product)));
	}

	@PutMapping("/product/{productId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> updateProduct(@Valid @RequestBody ProductDTO productDTO,
			@PathVariable("productId") int productId, Principal user)
			throws InvalidProductIdException, InternalServerException, UnauthorizedUserException {
		List<Product> updatedProduct = productService.updateProduct(productDTO, user.getName(), productId);
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, "SUCCESS",
				"Product Updated Successfully.", new ArrayList<Object>(updatedProduct)));
	}

	@DeleteMapping("/product/{id}")
	@PreAuthorize("hasRole('admin')")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id, HttpServletRequest request)
			throws InvalidProductIdException, UnauthorizedUserException {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new SuccessResponse(200, "SUCCESS", "Product Deleted Successfully."));
	}

	@GetMapping("/listMostRecent")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> listMostRecentProducts(Principal user) throws NoProductFoundException {
		List<Product> listMostRecentProduct = productService.listMostRecentProduct(user.getName());
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, "SUCCESS",
				"Recently Visited Products Retrived Successfully.", new ArrayList<Object>(listMostRecentProduct)));
	}

	@GetMapping("/userProduct")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> getProductsByUser(Principal user) {
		List<Product> products = productService.getProductByUserEmail(user.getName());
		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, "SUCCESS",
				"Products Retrived Successfully.", new ArrayList<Object>(products)));
	}
	
//	private static final String UPLOAD_DIR = "C:\\Users\\kanaka\\Downloads\\product_management_frontend\\src\\app\\uploads\\";
//
//    @PostMapping("/upload")
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<String> handleFileUpload(MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Please select a file to upload.");
//        }
//
//        try {
//            // Create the uploads directory if it doesn't exist
//            File directory = new File(UPLOAD_DIR);
//            if (!directory.exists()) {
//                directory.mkdir();
//            }
//
//            // Save the file to the uploads directory
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            return ResponseEntity.ok("File uploaded successfully!");
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Failed to upload file.");
//        }
//    }
}