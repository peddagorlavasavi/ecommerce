package com.hcl.ecommerce.service;


import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.dto.UserResponseDto;

/**
 * @author Vasavi
 *
 */
public interface UserService {

	/**
	 * 
	 * @description this method is used for to save the data in to the user.
	 * @param userRequestDto the userRequestDto which contains userName,password and mobileNumber
	 * @return userResponseDto
	 */
	public UserResponseDto save(UserRequestDto userRequestDto);

}
