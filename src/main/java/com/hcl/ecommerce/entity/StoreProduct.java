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
 * This is an database entity which describes the storeProduct.
 * 
 * @author Vasavi
 *
 */
@Entity
@Table(name = "store_products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer storeProductId;
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private Float productPrice;

}
