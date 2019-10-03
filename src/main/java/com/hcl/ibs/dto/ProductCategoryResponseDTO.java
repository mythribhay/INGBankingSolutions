package com.hcl.ibs.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ibs.repository.ProductCategoryRepository;
import com.hcl.ibs.repository.ProductRepository;

@Service
public class ProductCategoryResponseDTO {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	public List<ProductCategoryResponseDTO> fetchProductCategory() {
		
//		List<ProductCategoryResponseDTO> ListOfProductCategoryResponseDTO= productRepository.findAll()
		return null;
	}
	
}
