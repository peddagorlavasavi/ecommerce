package com.hcl.ecommerce.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.hcl.ecommerce.dto.StoreReviewDto;
import com.hcl.ecommerce.dto.StoreReviewResponseDto;
import com.hcl.ecommerce.service.StoreReviewServiceImpl;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for store review controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreReviewControllerTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	/**
	 * The storeReviewService.
	 */
	@Mock
	StoreReviewServiceImpl storeReviewService;

	/**
	 * The storeReviewController.
	 */
	@InjectMocks
	StoreReviewController storeReviewController;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReviewTest() {
		logger.info("Inside the reviewTest method");
		StoreReviewDto storeReviewDto = new StoreReviewDto();
		storeReviewDto.setStoreId(6);
		storeReviewDto.setRating(3.0);
		StoreReviewResponseDto storeReviewResponseDto = new StoreReviewResponseDto();
		storeReviewResponseDto.setStatusMessage("Success");
		storeReviewResponseDto.setStatusCode("200");
		when(storeReviewService.review(storeReviewDto)).thenReturn(storeReviewResponseDto);

		ResponseEntity<StoreReviewResponseDto> result = storeReviewController.review(storeReviewDto);
		assertEquals("200", result.getBody().getStatusCode());
	}

	@Test
	public void testGetAll() {
		logger.info("Inside the getAllTest method");
		StoreReviewDto storeReviewDto = new StoreReviewDto();
		storeReviewDto.setStoreId(6);
		storeReviewDto.setRating(3.0);
		List<StoreReviewDto> dto = new ArrayList<>();
		when(storeReviewService.getAll()).thenReturn(dto);
		ResponseEntity<List<StoreReviewDto>> result = storeReviewController.getAll();
		assertThat(result.getBody()).hasSize(0);
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}

	}

}
