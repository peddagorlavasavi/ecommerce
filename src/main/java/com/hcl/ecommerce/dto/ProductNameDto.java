package com.hcl.ecommerce.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Vasavi
 *
 */
@Setter
@Getter
@ToString
public class ProductNameDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String productName;

}
