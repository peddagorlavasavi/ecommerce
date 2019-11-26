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

import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for user service.
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)

public class UserServiceImplTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	/**
	 * The userService.
	 */
	@InjectMocks
	UserServiceImpl userService;
	/**
	 * The userRepository.
	 */
	@Mock
	UserRepository userRepository;

	UserResponseDto userResponseDto;
	UserRequestDto userRequestDto;
	User user;

	public UserResponseDto getUserResponseDto() {
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setStatusMessage("User Stored Successfully");
		userResponseDto.setStatusCode("200");
		return userResponseDto;
	}

	public UserRequestDto getUserRequestDto() {
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setUserName("vasavi");
		userRequestDto.setPassword("vasavi@123");
		userRequestDto.setMobileNumber("9538156731");
		return userRequestDto;
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
	public void setUp() {
		user = getUser();
		userRequestDto = getUserRequestDto();
		userResponseDto = getUserResponseDto();
	}

	@Test
	public void testSave() {
		logger.info("Inside the saveTest method");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		UserResponseDto userResponseDto = userService.save(userRequestDto);
		assertEquals("User Stored Successfully", userResponseDto.getStatusMessage());

	}

}
