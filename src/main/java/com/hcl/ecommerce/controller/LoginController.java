package com.hcl.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.LoginDto;
import com.hcl.ecommerce.dto.LoginResponseDto;
import com.hcl.ecommerce.service.LoginService;

/**
 * @author Vasavi
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	/**
	 * @description this method is used for logging into the application.
	 * @param loginDto the loginDto which contains  mobileNumber and password
	 * @return loginResponseDto
	 */
	@PostMapping("")
	public ResponseEntity<LoginResponseDto> login(LoginDto loginDto) {
	logger.debug("In LoginController:login");
		LoginResponseDto loginResponseDto = loginService.login(loginDto);
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);

	}

}
