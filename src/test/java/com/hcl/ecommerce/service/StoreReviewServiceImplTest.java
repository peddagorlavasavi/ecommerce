package com.hcl.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.hcl.ecommerce.dto.StoreReviewDto;
import com.hcl.ecommerce.dto.StoreReviewResponseDto;
import com.hcl.ecommerce.entity.StoreReview;
import com.hcl.ecommerce.repository.StoreReviewRepository;

/**
 * @author Vasavi
 * @description this class is used for to do test operations for store-review service.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreReviewServiceImplTest {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImplTest.class);
	/**
	 * The storeService.
	 */
	@InjectMocks
	StoreReviewServiceImpl storeReviewService;
	/**
	 * The storeRepository.
	 */
	@Mock
	StoreReviewRepository storeReviewRepository;

	StoreReviewDto storeReviewDto;
	StoreReviewResponseDto storeReviewResponseDto;
	StoreReview storeReview;
	StoreReviewDto storeReviewDtos;

	public StoreReviewResponseDto getStoreReviewResponseDto() {
		StoreReviewResponseDto storeReviewResponseDto = new StoreReviewResponseDto();
		storeReviewResponseDto.setStatusMessage("Success");
		storeReviewResponseDto.setStatusCode("200");
		return storeReviewResponseDto;
	}

	public StoreReviewDto getStoreReviewDto() {
		StoreReviewDto storeReviewDto = new StoreReviewDto();
		storeReviewDto.setStoreId(6);
		storeReviewDto.setRating(3.0);
		return storeReviewDto;
	}

	public StoreReviewDto getStoreReviewDtos() {
		storeReviewDtos = new StoreReviewDto();
		storeReviewDtos.setStoreId(1);
		storeReviewDtos.setRating(2.0);
		return storeReviewDtos;
	}

	public StoreReview getStoreReview() {
		StoreReview storeReview = new StoreReview();
		storeReview.setStoreReviewId(27);
		storeReview.setStoreId(6);
		storeReview.setRating(3.5);
		storeReview.setCount(1);
		return storeReview;

	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		storeReview = getStoreReview();
		storeReviewDto = getStoreReviewDto();
		storeReviewResponseDto = getStoreReviewResponseDto();
		storeReviewDtos = getStoreReviewDtos();
	}

	@Test
	public void testReview() {
		logger.info("Inside the reviewTest method");
		Optional<StoreReview> isOptionalStoreReview = Optional.of(storeReview);
		Mockito.when(storeReviewRepository.findByStoreId(storeReviewDto.getStoreId()))
				.thenReturn(isOptionalStoreReview);
		StoreReviewResponseDto storeReviewResponseDto = storeReviewService.review(storeReviewDto);
		assertEquals("Success", storeReviewResponseDto.getStatusMessage());
	}

	@Test
	public void testReviewNegative() {
		logger.info("Inside the reviewNegativeTest method");
		Optional<StoreReview> isOptionalStoreReview = Optional.of(storeReview);
		Mockito.when(storeReviewRepository.findByStoreId(storeReviewDto.getStoreId()))
				.thenReturn(isOptionalStoreReview);
		StoreReviewResponseDto storeReviewResponseDto = storeReviewService.review(storeReviewDtos);
		assertEquals("Success", storeReviewResponseDto.getStatusMessage());

	}

	@Test
	public void testGetAll() {
		logger.info("Inside the getAllTest method ");
		List<StoreReview> storeReviews = new ArrayList<>();
		Mockito.when(storeReviewRepository.findAll()).thenReturn(storeReviews);
		List<StoreReviewDto> result = storeReviewService.getAll();
		assertThat(result).hasSize(0);
	}
}
