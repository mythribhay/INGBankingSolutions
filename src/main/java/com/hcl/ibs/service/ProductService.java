package com.hcl.ibs.service;

import java.util.List;

import com.hcl.ibs.dto.ProductCategoryResponseDTO;
import com.hcl.ibs.entity.ProductCategory;

public interface ProductService {
	
//	public List<ProductCategoryResponseDTO> fetchProductCategory();
	public List<ProductCategory> fetchProductCategory();

	
}
