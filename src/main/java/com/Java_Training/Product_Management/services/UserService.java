//package com.Java_Training.Product_Management.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
////import com.Java_Training.Product_Management.KeycloakSecurity.GenerateUserToken;
//import com.Java_Training.Product_Management.KeycloakSecurity.UserRequest;
////import com.Java_Training.Product_Management.dto.LogoutDataDto;
//import com.Java_Training.Product_Management.dto.UserDTO;
//import com.Java_Training.Product_Management.entities.User;
//import com.Java_Training.Product_Management.exceptions.InternalServerException;
//import com.Java_Training.Product_Management.mapper.UserMapper;
//import com.Java_Training.Product_Management.repository.UserRepository;
//import com.Java_Training.Product_Management.utils.CreateKeyCloakUser;
////import com.Java_Training.Product_Management.utils.KeyCloakAccessTokenResponse;
////import com.Java_Training.Product_Management.utils.LogoutKeyCloakUser;
//
//@Component
//public class UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private CreateKeyCloakUser createKeyCloakUser;
//
//	public List<UserDTO> addNewUser(UserDTO userDto) throws InternalServerException {
//
////		validation for duplicate email
//		User isAlreadyPresentUser = userRepository.findByEmail(userDto.getEmail());
//		if (isAlreadyPresentUser != null) {
//			throw new InternalServerException("User with this email already exists");
//		}
//
////		Creating a new user profile on KeyCloak
//		UserRequest request = new UserRequest(userDto.getEmail(), userDto.getName(), userDto.getName(),
//				userDto.getPassword());
//		boolean newUser = createKeyCloakUser.createUser(request);
//
//		if (newUser == false) {
//			throw new InternalServerException("Failed while creating user, Please try again");
//		}
//
////		Inserting details of user to database
//		User user = UserMapper.convertDtoToEntity(userDto);
//		User savedUser = userRepository.save(user);
//
//		UserDTO savedUserDto = UserMapper.convertEntityToDto(savedUser);
//
//		List<UserDTO> savedUserList = new ArrayList<UserDTO>();
//		savedUserList.add(savedUserDto);
//
//		return savedUserList;
//	}
//
////	public KeyCloakAccessTokenResponse login(UserDTO userDto) throws InternalServerException {
//////		List<String> token = new GenerateUserToken().getToken(userDto.getEmail(), userDto.getPassword());
//////		if (token.get(0) == "") {
//////			throw new InternalServerException("Failed to login! Please try again");
//////		}
////		
////		List<String> token = new ArrayList<String>();
//////		creating a valid response with access and refresh token
////		KeyCloakAccessTokenResponse response = new KeyCloakAccessTokenResponse(200, "SUCCESS", "Login Successfully","","");
////		return response;
////	}
////
////	public String logout(LogoutDataDto logoutDataDto) throws InternalServerException {
////		boolean isLogout = new LogoutKeyCloakUser().Logout(logoutDataDto.getRefreshToken());
////		if (isLogout == false) {
////			throw new InternalServerException("Failed to logout! Please try again");
////		}
////		return "Logout Successfully";
////	}
//}
