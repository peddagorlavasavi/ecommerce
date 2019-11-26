package com.hcl.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreReviewDto;
import com.hcl.ecommerce.dto.StoreReviewResponseDto;
import com.hcl.ecommerce.entity.StoreReview;
/**
 * @author Vasavi
 *
 */
import com.hcl.ecommerce.repository.StoreReviewRepository;

@Service
public class StoreReviewServiceImpl implements StoreReviewService {

	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreReviewServiceImpl.class);
	/**
	 * The storeReviewRepository.
	 */
	@Autowired
	StoreReviewRepository storeReviewRepository;

	/**
	 * @description this method is used for to give the rating for the particular
	 *              store based on the storeId.
	 * @param storeReviewDto the storeReviewDto which contains storeId and rating.
	 * @return storeReviewResponseDto.
	 *
	 */
	@Override
	public StoreReviewResponseDto review(StoreReviewDto storeReviewDto) {
		logger.info("In review() method ");
		StoreReviewResponseDto storeReviewResponseDto = new StoreReviewResponseDto();
		Optional<StoreReview> storeReview = storeReviewRepository.findByStoreId(storeReviewDto.getStoreId());
		if (storeReview.isPresent()) {
			Double latestRating = (storeReview.get().getRating() * storeReview.get().getCount()
					+ storeReviewDto.getRating()) /( storeReview.get().getCount() + 1);
			int count = storeReview.get().getCount() + 1;
		
			storeReview.get().setCount(count);
			storeReview.get().setRating(latestRating);
			storeReviewRepository.save(storeReview.get());

		} else {
			StoreReview	storeReviewUpdated = new StoreReview(0, storeReviewDto.getStoreId(), storeReviewDto.getRating().doubleValue(), 1);
			storeReviewRepository.save(storeReviewUpdated);
		}
		storeReviewResponseDto.setStatusMessage("Success");
		storeReviewResponseDto.setStatusCode("200");
		return storeReviewResponseDto;
	}

	/**
	 * @description this method is used for to get all the stores with user given ratings.
	 *@return storeReviewDto
	 */
	@Override
	public List<StoreReviewDto> getAll() {
		return storeReviewRepository.findAll().stream().map(x-> new StoreReviewDto(x.getStoreId(),x.getRating())).collect(Collectors.toList());
	}

}
