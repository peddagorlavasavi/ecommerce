package com.hcl.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.service.UserService;

/**
 * @author Vasavi
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * @description this method is used for to save the data in to the user.
	 * @param userRequestDto the userRequestDto which contains userName,password and mobileNumber
	 * @return userResponseDto
	 */
	@GetMapping("")
	public ResponseEntity<UserResponseDto> save( UserRequestDto userRequestDto) {
		logger.debug("In UserController:save");
		UserResponseDto userResponseDto = userService.save(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
	}

}
