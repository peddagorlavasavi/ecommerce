package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for store service.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreServiceImplTest {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImplTest.class);
	/**
	 * The storeService.
	 */
	@InjectMocks
	StoreServiceImpl storeService;
	/**
	 * The storeRepository.
	 */
	@Mock
	StoreRepository storeRepository;

	StoreRequestDto storeRequestDto;
	StoreResponseDto storeResponseDto;
	Store store;

	public StoreResponseDto getStoreResponseDto() {
		StoreResponseDto storeResponseDto = new StoreResponseDto();
		storeResponseDto.setStatusMessage(" Store added Successfully");
		storeResponseDto.setStatusCode("200");
		return storeResponseDto;
	}

	public StoreRequestDto getStoreRequestDto() {
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		storeRequestDto.setStoreName("BigBazar");
		storeRequestDto.setStoreLocation("Bngl");
		return storeRequestDto;

	}

	public Store getStore() {
		Store store = new Store();
		store.setStoreId(1);
		store.setStoreName("BigBazar");
		store.setStoreLocation("Bngl");
		return store;

	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		storeResponseDto = getStoreResponseDto();
		storeRequestDto = getStoreRequestDto();
		store = getStore();

	}

	@Test
	public void testAddStore() {
		logger.info("Inside the addStoreTest method");
		Mockito.when(storeRepository.save(store)).thenReturn(new Store());
		StoreResponseDto storeResponseDto = storeService.addStore(storeRequestDto);
		assertEquals("Data Stored Successfully", storeResponseDto.getStatusMessage());
		
	}

}
