package com.hcl.ibs.service;

import java.util.List;

import com.hcl.ibs.dto.ProductDetailsResponseDTO;
import com.hcl.ibs.dto.ProductResponseDTO;
import com.hcl.ibs.entity.ProductCategory;

public interface ProductService {
	
	public List<ProductCategory> fetchProductCategory();

	List<ProductResponseDTO> fetchProduct(int categoryId);
	
	List<ProductDetailsResponseDTO> fetchProductDetails(int productId);

	
}
