package com.hcl.ibs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ibs.dto.ProductCategoryResponseDTO;

@RestController
public class ProductController {

	
	@GetMapping("/category")
	public List<ProductCategoryResponseDTO> getProductCategoryList() {
		List<ProductCategoryResponseDTO> ListOfProductCategoryResponseDTO;
		return null;

		
	}
}
