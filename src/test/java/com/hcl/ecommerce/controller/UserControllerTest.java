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
import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.service.UserService;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for user controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	/**
	 * The userService.
	 */
	@Mock
	UserService userService;

	/**
	 * The userController.
	 */
	@InjectMocks
	UserController userController;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testsave() {
		logger.info("Inside the saveTest method");
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setUserName("vasavi");
		userRequestDto.setPassword("vasavi@123");
		userRequestDto.setMobileNumber("9538156731");
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setStatusMessage("User Stored Successfully");
		userResponseDto.setStatusCode("200");
		when(userService.save(userRequestDto)).thenReturn(userResponseDto);

		ResponseEntity<UserResponseDto> result = userController.save(userRequestDto);
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
