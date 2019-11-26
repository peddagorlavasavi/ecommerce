package com.hcl.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is an database entity which describes the storeReviews.
 * 
 * @author Vasavi
 *
 */
@Entity
@Table(name = "store_reviews")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreReview implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer storeReviewId;
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "rating")
	private Double rating;
	@Column(name = "count")
	private Integer count;

}
