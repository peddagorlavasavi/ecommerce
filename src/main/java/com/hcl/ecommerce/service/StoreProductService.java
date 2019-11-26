package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ProductNameDto;
import com.hcl.ecommerce.dto.ProductNameResponseDto;
import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.dto.StoreProductResponseDto;

/**
 * @author Vasavi
 *
 */
public interface StoreProductService {

	/**
	 * 
	 * @description this method is used for adding products into the application.
	 * @param storeProductDto the storeProductDto which contains
	 *                        storeId,productId,productId and ProductPrice.
	 * @return storeProductResponseDto.
	 */
	public StoreProductResponseDto saveProduct(StoreProductDto storeProductDto);

	/**
	 * 
	 * @description this method is used for searching the products based on the
	 *              productName.
	 * @param productNameDto the productNameDto which contains
	 *                       productId,productName,productPrice and StoreId.
	 * @return productNameResponseDto.
	 */

	public List<ProductNameResponseDto> findByProductNameStartsWith(ProductNameDto productNameDto);

}
