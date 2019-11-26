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
import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.service.StoreService;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for store controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreControllerTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreControllerTest.class);
	/**
	 * The storeService.
	 */
	@Mock
	StoreService storeService;

	/**
	 * The storeController.
	 */
	@InjectMocks
	StoreController storeController;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddStore() throws Exception {
		logger.info("Inside the addStoreTest method");
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		storeRequestDto.setStoreName("more");
		storeRequestDto.setStoreLocation("Bangalore");
		StoreResponseDto storeResponseDto = new StoreResponseDto();
		storeResponseDto.setStatusMessage("Data Stored Successfully");
		storeResponseDto.setStatusCode("200");
		when(storeService.addStore(storeRequestDto)).thenReturn(storeResponseDto);

		ResponseEntity<StoreResponseDto> result = storeController.addStore(storeRequestDto);
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
