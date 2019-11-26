package com.hcl.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * @author Vasavi
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

	/**
	 * The storeRepository.
	 */
	@Autowired
	StoreRepository storeRepository;

	/**
	 *@description this method is used for to add the stores into the application.
	 *@param storeRequestDto the storeRequestDto which contains storeName and storeLocation.
	 *@return storeResponseDto.
	 *
	 */
	@Override
	public StoreResponseDto addStore(StoreRequestDto storeRequestDto) {
		logger.info("Inside of addstore() method");
		Store store = new Store();
		StoreResponseDto storeResponseDto = new StoreResponseDto();
		BeanUtils.copyProperties(storeRequestDto, store);
		storeRepository.save(store);
		storeResponseDto.setStatusMessage("Data Stored Successfully");
		storeResponseDto.setStatusCode("200");
		return storeResponseDto;
	}

}
