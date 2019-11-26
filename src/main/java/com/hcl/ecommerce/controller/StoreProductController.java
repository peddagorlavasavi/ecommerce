package com.hcl.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ProductNameDto;
import com.hcl.ecommerce.dto.ProductNameResponseDto;
import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.dto.StoreProductResponseDto;
import com.hcl.ecommerce.service.StoreProductService;

/**
 * @author Vasavi
 *
 */
@RestController
@RequestMapping("/storeProducts")
public class StoreProductController {

	private static final Logger logger = LoggerFactory.getLogger(StoreProductController.class);
	@Autowired
	StoreProductService storeProductService;

	/**
	 * @description this method is used for adding products into the application.
	 * @param storeProductDto the storeProductDto which contains storeId,productId,productName and productPrice.
	 * @return storeProductResponseDto.
	 */
	@GetMapping("")
	public ResponseEntity<StoreProductResponseDto> saveProduct(StoreProductDto storeProductDto) {
	logger.debug("In StoreProductController:saveProduct");
		StoreProductResponseDto storeProductRepsonseDto = storeProductService.saveProduct(storeProductDto);
		return new ResponseEntity<>(storeProductRepsonseDto, HttpStatus.OK);
	}

	/**
	 * @description this method is used for searching the products based on the
	 *              productName.
	 * @param productNameDto the productNameDto which contains productName.
	 * @return productNameResponseDto.
	 */
	@GetMapping("/{productname}")
	public ResponseEntity<List<ProductNameResponseDto>> getProductname(ProductNameDto productNameDto) {
		logger.debug("In StoreProductController:getProductName");
		List<ProductNameResponseDto> productNameResponseDto = storeProductService
				.findByProductNameStartsWith(productNameDto);
		return new ResponseEntity<>(productNameResponseDto, HttpStatus.OK);
	}
}
