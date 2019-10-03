package com.hcl.ibs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productCategoryId;
	private String productCategoryName;
	
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	
	
}
