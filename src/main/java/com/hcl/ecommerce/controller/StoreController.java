package com.hcl.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.service.StoreService;

/**
 * @author Vasavi
 *
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	StoreService storeService;

	/**
	 * @description this method is used for logging into the application.
	 * @param storeRequestDto the storeRequestDto which contains  storeName and storeLocation
	 * @return storeResponseDto
	 */
	@GetMapping("")
	public ResponseEntity<StoreResponseDto> addStore(StoreRequestDto storeRequestDto) {
		logger.debug("In store contoller:addStore");
		StoreResponseDto storeResponseDto = storeService.addStore(storeRequestDto);
		return new ResponseEntity<>(storeResponseDto, HttpStatus.OK);
	}

}
