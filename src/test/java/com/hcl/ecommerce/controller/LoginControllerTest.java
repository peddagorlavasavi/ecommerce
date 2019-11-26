package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ecommerce.dto.LoginDto;
import com.hcl.ecommerce.dto.LoginResponseDto;
import com.hcl.ecommerce.service.LoginService;

/**
 * @author Vasavi
 * @description this class is used for to test operation for login controller. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);
	/**
	 * The loginService.
	 */
	@Mock
	LoginService loginService;

	/**
	 * The loginController.
	 */
	@InjectMocks
	LoginController loginController;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin() throws Exception {
		logger.info("Inside the loginTest method");
		LoginDto loginDto = new LoginDto();
		loginDto.setMobileNumber("953816731");
		loginDto.setPassword("vasavi@123");
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setStatusMessage("Login Success..");
		loginResponseDto.setStatusCode("200");

		when(loginService.login(loginDto)).thenReturn(loginResponseDto);

		ResponseEntity<LoginResponseDto> result = loginController.login(loginDto);
		assertEquals("200", result.getBody().getStatusCode());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}

	}

}
