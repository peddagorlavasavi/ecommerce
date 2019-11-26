package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductNameDto;
import com.hcl.ecommerce.dto.ProductNameResponseDto;
import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.dto.StoreProductResponseDto;
import com.hcl.ecommerce.entity.StoreProduct;
import com.hcl.ecommerce.repository.StoreProductRepository;

/**
 * @author Vasavi
 *
 */
@Service
public class StoreProductServiceImpl implements StoreProductService {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreProductServiceImpl.class);
	/**
	 * The storeProductRepository.
	 */
	@Autowired
	StoreProductRepository storeProductRepository;

	/**
	 *
	 *@description this method is used for adding products into the application.
	 * @param storeProductDto the storeProductDto which contains
	 *                        storeId,productId,productName and productPrice.
	 * @return storeProductResponseDto.
	 *
	 */
	@Override
	public StoreProductResponseDto saveProduct(StoreProductDto storeProductDto) {
		logger.info("Inside of saveProduct() method");
		StoreProduct storeProduct = new StoreProduct();
		StoreProductResponseDto storeProductResponseDto = new StoreProductResponseDto();
		BeanUtils.copyProperties(storeProductDto, storeProduct);
		storeProductRepository.save(storeProduct);
		storeProductResponseDto.setStatusMessage("Success");
		storeProductResponseDto.setStatusCode("200");
		return storeProductResponseDto;
	}

	/**
	 *@description this method is used for searching the products based on the
	 *              productName.
	 * @param productNameDto the productNameDto which contains productName.
	 * @return productNameResponseDto.
	 *
	 */
	@Override
	public List<ProductNameResponseDto> findByProductNameStartsWith(ProductNameDto productNameDto) {
		List<StoreProduct> storeProducts = storeProductRepository
				.findByProductNameStartsWith(productNameDto.getProductName());
		List<ProductNameResponseDto> dto = new ArrayList<>();
		for (StoreProduct storeProduct : storeProducts) {
			ProductNameResponseDto productNameResponseDto = new ProductNameResponseDto();
			BeanUtils.copyProperties(storeProduct, productNameResponseDto);
			dto.add(productNameResponseDto);

		}

		return dto;
	}

}
