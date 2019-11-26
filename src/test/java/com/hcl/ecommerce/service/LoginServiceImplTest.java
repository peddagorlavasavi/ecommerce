package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.ecommerce.dto.LoginDto;
import com.hcl.ecommerce.dto.LoginResponseDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.LoginRepository;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for login service.
 */
@RunWith(MockitoJUnitRunner.Silent.class)

public class LoginServiceImplTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImplTest.class);
	/**
	 * The loginService.
	 */
	@InjectMocks
	LoginServiceImpl loginService;
	/**
	 * The loginReposiotry.
	 */
	@Mock
	LoginRepository loginRepository;
	User user;
	LoginDto loginDto;
	LoginResponseDto loginResponseDto;
	LoginDto loginDtos;// To check for the negative test case

	public LoginResponseDto getLoginResponseDto() {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setStatusMessage("Login Successfully");
		loginResponseDto.setStatusCode("200");
		return loginResponseDto;

	}

	// to check for the negative test case
	public LoginDto getLoginDtos() {
		loginDtos = new LoginDto();
		loginDtos.setMobileNumber("9538156720");
		loginDtos.setPassword("vasavi@111");
		return loginDtos;
	}

	public LoginDto getLoginDto() {
		LoginDto loginDto = new LoginDto();
		loginDto.setMobileNumber("9538156731");
		loginDto.setPassword("vasavi@123");
		return loginDto;
	}

	public User getUser() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("vasavi");
		user.setMobileNumber("953816731");
		user.setPassword("vasavi@123");
		return user;
	}

	@Before
	public void setup() {
		loginDto = getLoginDto();
		loginResponseDto = getLoginResponseDto();
		user = getUser();
		loginDtos = getLoginDtos();
	}

	@Test
	public void testLogin() {
		logger.info("Inside the loginTest method");
		Mockito.when(loginRepository.findByMobileNumberAndPassword(loginDto.getMobileNumber(), loginDto.getPassword()))
				.thenReturn(user);
		LoginResponseDto loginResponseDto = loginService.login(loginDto);
		assertEquals("Login Successfully", loginResponseDto.getStatusMessage());
	}

	@Test
	public void testLoginNegative() {
		logger.info("Inside the loginNegativeTest method");
		Mockito.when(loginRepository.findByMobileNumberAndPassword(loginDto.getMobileNumber(), loginDto.getPassword()))
				.thenReturn(user);
		LoginResponseDto loginResponseDto = loginService.login(loginDtos);
		assertEquals("Enter Valid MobileNo and Password", loginResponseDto.getStatusMessage());
	}
}
