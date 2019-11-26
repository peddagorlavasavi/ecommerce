package com.hcl.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.LoginDto;
import com.hcl.ecommerce.dto.LoginResponseDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.LoginRepository;

/**
 * @author Vasavi
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/**
	 *  The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	/**
	 * The loginRepository.
	 */
	@Autowired
	LoginRepository loginRepository;

	
	/**
	 *
	 *@description this method is used for logging into the application.
	 *@param logindto the loginDto which contains mobileNumber and password.
	 *@return loginResponseDto.
	 *
	 *
	 */
	@Override
	public LoginResponseDto login(LoginDto loginDto) {
		logger.debug("LoginServiceImpl login()");
		LoginResponseDto loginResponseDto = null;
		User user = loginRepository.findByMobileNumberAndPassword(loginDto.getMobileNumber(), loginDto.getPassword());
		if (user != null) {
			loginResponseDto = new LoginResponseDto();
			loginResponseDto.setStatusCode("200");
			loginResponseDto.setStatusMessage("Login Successfully");
		}
		else {
			loginResponseDto = new LoginResponseDto();
			loginResponseDto.setStatusCode("401");
			loginResponseDto.setStatusMessage("Enter Valid MobileNo and Password");
		}
		return loginResponseDto;
	}

}
