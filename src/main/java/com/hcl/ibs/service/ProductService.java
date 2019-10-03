package com.hcl.ibs.service;

import java.util.List;

import com.hcl.ibs.dto.ProductCategoryResponseDTO;

public interface ProductService {
	
	public List<ProductCategoryResponseDTO> fetchProductCategory();
}
