package com.hcl.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

/**
 * @author Vasavi
 *
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * The Constant log.
	 */
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * The userRepository.
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * @description this method is used for to save the data in to the user.
	 *@param userRequestDto the userRequestDto which contains userName,password and mobileNumber.
	 *@return userResponseDto.
	 *
	 */
	@Override
	public UserResponseDto save(UserRequestDto userRequestDto) {
		logger.info("Inside of save() method");
		User user = new User();
		UserResponseDto userResponseDto = new UserResponseDto();
		BeanUtils.copyProperties(userRequestDto, user);
		userRepository.save(user);
		userResponseDto.setStatusMessage("User Stored Successfully");
		userResponseDto.setStatusCode("200");
		return userResponseDto;
	}

}
