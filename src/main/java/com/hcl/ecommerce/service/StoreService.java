package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.dto.StoreResponseDto;

/**
 * @author Vasavi
 *
 */
public interface StoreService {

	/**
	 * 
	 * @description this method is used for to add the stores into the application.
	 * @param storeRequestDto the storeRequestDto which contains  storeName and storeLocation
	 * @return storeResponseDto
	 */
	public StoreResponseDto addStore(StoreRequestDto storeRequestDto);

}
