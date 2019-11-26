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
import com.hcl.ecommerce.dto.ProductNameDto;
import com.hcl.ecommerce.dto.ProductNameResponseDto;
import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.dto.StoreProductResponseDto;
import com.hcl.ecommerce.service.StoreProductServiceImpl;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for store product controller.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreProductControllerTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	/**
	 * The storeProductService.
	 */
	@Mock
	StoreProductServiceImpl storeProductService;

	/**
	 * The storeProductController.
	 */
	@InjectMocks
	StoreProductController storeProductController;

	MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveProduct() {
		logger.info("Inside the saveProductTest method");
		StoreProductDto storeProductDto = new StoreProductDto();
		storeProductDto.setProductId(2);
		storeProductDto.setProductName("Bag");
		storeProductDto.setProductPrice(2250f);
		storeProductDto.setStoreId(3);
		StoreProductResponseDto storeProductResponseDto = new StoreProductResponseDto();
		storeProductResponseDto.setStatusMessage("Success");
		storeProductResponseDto.setStatusCode("200");
		when(storeProductService.saveProduct(storeProductDto)).thenReturn(storeProductResponseDto);

		ResponseEntity<StoreProductResponseDto> result = storeProductController.saveProduct(storeProductDto);
		assertEquals("200", result.getBody().getStatusCode());
	}

	@Test
	public void testGetProductName() {
		logger.info("Inside the getProductNameTest mehod");
		ProductNameDto productNameDto = new ProductNameDto();
		productNameDto.setProductName("Bag");
		ProductNameResponseDto productNameResponseDto = new ProductNameResponseDto();
		productNameResponseDto.setProductId(2);
		productNameResponseDto.setProductName("Bag");
		productNameResponseDto.setProductPrice(2250f);
		productNameResponseDto.setStoreId(3);
		List<ProductNameResponseDto> dto = new ArrayList<>();
		when(storeProductService.findByProductNameStartsWith(productNameDto)).thenReturn(dto);

		ResponseEntity<List<ProductNameResponseDto>> result = storeProductController.getProductname(productNameDto);
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
