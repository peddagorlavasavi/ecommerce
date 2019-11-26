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
 * This is an database entity which describes the store.
 * 
 * @author Vasavi
 *
 */
@Entity
@Table(name = "stores")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer storeId;
	@Column(name = "store_name")
	private String storeName;
	@Column(name = "store_location")
	private String storeLocation;

}
