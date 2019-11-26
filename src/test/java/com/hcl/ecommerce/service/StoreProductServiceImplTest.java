package com.hcl.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.ecommerce.dto.ProductNameDto;
import com.hcl.ecommerce.dto.ProductNameResponseDto;
import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.dto.StoreProductResponseDto;
import com.hcl.ecommerce.entity.StoreProduct;
import com.hcl.ecommerce.repository.StoreProductRepository;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for store-product service.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreProductServiceImplTest {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreProductServiceImplTest.class);
	/**
	 * The storeProductService.
	 */
	@InjectMocks
	StoreProductServiceImpl storeProductService;
	/**
	 * The storeProductRepository.
	 */
	@Mock
	StoreProductRepository storeProductRepository;

	StoreProduct storeProduct;
	StoreProductDto storeProductDto;
	StoreProductResponseDto storeProductResponseDto;
	ProductNameDto productNameDto;
	ProductNameResponseDto productNameResponseDto;

	public StoreProductResponseDto getStoreProductResponseDto() {
		StoreProductResponseDto storeProductResponseDto = new StoreProductResponseDto();
		storeProductResponseDto.setStatusMessage("Success");
		storeProductResponseDto.setStatusCode("200");
		return storeProductResponseDto;
	}

	public StoreProductDto getStoreProductDto() {
		StoreProductDto storeProductDto = new StoreProductDto();
		storeProductDto.setProductId(2);
		storeProductDto.setProductName("Bag");
		storeProductDto.setProductPrice(2250f);
		storeProductDto.setProductId(3);
		return storeProductDto;
	}

	public StoreProduct getStoreProduct() {
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setStoreProductId(1);
		storeProduct.setProductId(2);
		storeProduct.setProductName("Bag");
		storeProduct.setProductPrice(2250f);
		storeProduct.setStoreId(3);
		return storeProduct;

	}

	public ProductNameDto getProductNameDto() {
		ProductNameDto productNameDto = new ProductNameDto();
		productNameDto.setProductName("Bag");
		return productNameDto;
	}

	public ProductNameResponseDto getProductNameResponseDto() {
		ProductNameResponseDto productNameResponseDto = new ProductNameResponseDto();
		productNameResponseDto.setProductId(2);
		productNameResponseDto.setProductName("Bag");
		productNameResponseDto.setProductPrice(2250f);
		productNameResponseDto.setStoreId(6);
		return productNameResponseDto;
	}

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);

		storeProductDto = getStoreProductDto();
		storeProductResponseDto = getStoreProductResponseDto();
		storeProduct = getStoreProduct();
		productNameDto = getProductNameDto();
		productNameResponseDto = getProductNameResponseDto();

	}

	@Test
	public void testSaveProduct() {
		logger.info("Inside  the saveProdctTest method");
		Mockito.when(storeProductRepository.save(storeProduct)).thenReturn(new StoreProduct());

		StoreProductResponseDto storeProductResponseDto = storeProductService.saveProduct(storeProductDto);
		assertEquals("Success", storeProductResponseDto.getStatusMessage());
	}

	@Test
	public void testFindByProductNameStartsWith() {
		logger.info("Inside the findByProductNameStartsWithTest method");
		List<StoreProduct> storeProducts = new ArrayList<>();
		StoreProduct storeProduct = getStoreProduct();
		storeProducts.add(storeProduct);
		Mockito.when(storeProductRepository.findByProductNameStartsWith(productNameDto.getProductName()))
				.thenReturn(storeProducts);
		List<ProductNameResponseDto> productNameResponseDto = storeProductService
				.findByProductNameStartsWith(productNameDto);
		assertThat(productNameResponseDto).hasSize(1);

		productNameResponseDto.forEach(dto -> {
			assertEquals(2, dto.getProductId());
			assertEquals("Bag", dto.getProductName());
			assertEquals(2250f, dto.getProductPrice());
			assertEquals(3, dto.getStoreId());
		});

	}
}
