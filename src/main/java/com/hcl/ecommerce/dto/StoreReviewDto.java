package com.hcl.ecommerce.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Vasavi
 *
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StoreReviewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer storeId;
	private Double rating;
	

}
