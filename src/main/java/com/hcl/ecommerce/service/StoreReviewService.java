package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.StoreReviewDto;
import com.hcl.ecommerce.dto.StoreReviewResponseDto;

/**
 * @author Vasavi
 *
 */
public interface StoreReviewService {

	/**
	 * @description this method is used for to give the rating for the particular
	 *              store based on the storeId.
	 * @param storeReviewDto the storeReviewDto which contains storeId and rating.
	 * @return storeReviewResponseDto.
	 */
	public StoreReviewResponseDto review(StoreReviewDto storeReviewDto);

	/**
	 * 
	 * @description this method is used for to get all the stores with user given ratings.
	 * @return storeReviewDto
	 */
	public List<StoreReviewDto> getAll();
}
