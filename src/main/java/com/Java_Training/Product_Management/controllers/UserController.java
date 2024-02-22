//package com.Java_Training.Product_Management.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import com.Java_Training.Product_Management.dto.LogoutDataDto;
//import com.Java_Training.Product_Management.dto.UserDTO;
//import com.Java_Training.Product_Management.exceptions.InternalServerException;
////import com.Java_Training.Product_Management.exceptions.LoginFailedException;
//import com.Java_Training.Product_Management.services.UserService;
////import com.Java_Training.Product_Management.utils.KeyCloakAccessTokenResponse;
//import com.Java_Training.Product_Management.utils.SuccessResponse;
//
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
////import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/auth")
//@SecurityRequirement(name = "Keycloak")
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//
//	@PostMapping("/signup")
//	public ResponseEntity<Object> addNewUser(@Valid @RequestBody UserDTO userDto) throws InternalServerException {
//		List<UserDTO> newUser = userService.addNewUser(userDto);
//		return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200, "SUCCESS",
//				"New user registred successfully.", new ArrayList<Object>(newUser)));
//	}
//
////	@PostMapping("/login")
////	public ResponseEntity<Object> login(@Valid @RequestBody UserDTO userDto)
////			throws LoginFailedException, InternalServerException {
////		KeyCloakAccessTokenResponse response = userService.login(userDto);
////		return ResponseEntity.status(HttpStatus.OK).body(response);
////	}
////
////	@PostMapping("/logout")
////	public ResponseEntity<Object> logout(@Valid @RequestBody LogoutDataDto logoutDataDto,HttpServletRequest request)
////			throws InternalServerException {
////		userService.logout(logoutDataDto);
////		return ResponseEntity.status(HttpStatus.OK)
////				.body(new SuccessResponse(200, "SUCCESS", "Logout Successfully", new ArrayList<Object>()));
////	}
//}
