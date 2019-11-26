package com.hcl.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreReviewDto;
import com.hcl.ecommerce.dto.StoreReviewResponseDto;
import com.hcl.ecommerce.service.StoreReviewService;

/**
 * @author Vasavi
 *
 */
@RestController
@RequestMapping("/storeReview")
public class StoreReviewController {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreReviewController.class);
	/**
	 * The storeReviewService.
	 */
	@Autowired
	StoreReviewService storeReviewService;

	/**
	 * @description this method is used for to give the rating for the particular
	 *              store based on the storeId.
	 * @param storeReviewDto the storeReviewDto which contains storeId and rating.
	 * @return storeReviewResponseDto.
	 */
	@PostMapping("")
	public ResponseEntity<StoreReviewResponseDto> review(StoreReviewDto storeReviewDto) {
		logger.debug("In StoreReviewController:review");
		StoreReviewResponseDto storeReviewResponseDto = storeReviewService.review(storeReviewDto);
		return new ResponseEntity<>(storeReviewResponseDto, HttpStatus.OK);
	}
	
	/**
	 * @return storeReviewDto.
	 */
	@GetMapping("")
	public ResponseEntity<List<StoreReviewDto>> getAll(){
		logger.debug("In StoreReviewController:getAll");
		return new ResponseEntity<>(storeReviewService.getAll(), HttpStatus.OK);
	}

}
