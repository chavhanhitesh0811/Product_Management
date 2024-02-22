package com.Java_Training.Product_Management.mapper;

import com.Java_Training.Product_Management.dto.UserDTO;
import com.Java_Training.Product_Management.entities.User;

public class UserMapper {

	public static User convertDtoToEntity(UserDTO userDto) {

		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		return user;
	}

	public static UserDTO convertEntityToDto(User user) {

		UserDTO userDto = new UserDTO();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());

		return userDto;
	}
}
