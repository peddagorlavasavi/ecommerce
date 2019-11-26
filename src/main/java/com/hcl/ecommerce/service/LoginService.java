package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.LoginDto;
import com.hcl.ecommerce.dto.LoginResponseDto;

/**
 * @author Vasavi
 * 
 */
public interface LoginService {

	/**
	 * 
	 * @description this method is used for logging into the application.
	 * @param loginDto the loginDto which contains mobileNumber and password
	 * @return loginResponseDto
	 */
	public LoginResponseDto login(LoginDto loginDto);

}
