package com.hcl.ibs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ibs.dto.ProductDetailsResponseDTO;
import com.hcl.ibs.dto.ProductResponseDTO;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.service.ProductService;

/**
 * 
 * @author Manisha Yadav
 *
 */

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	/**
	 * 
	 * @param no-parameter
	 * @return ProductCategoryResponseDTO-list of categories of products available in DB
	 */
	
	@GetMapping("/category")
	public ResponseEntity<List<ProductCategory>> getProductCategoryList() {
		logger.info(":: Enter into ProductController--------::getProductCategoryList()");
		List<ProductCategory> listOfProductCategoryResponseDTO= productService.fetchProductCategory();		
		return new ResponseEntity<>(listOfProductCategoryResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/product/{categoryId}")
	public ResponseEntity<List<ProductResponseDTO>> getProduct(int categoryId) {
		logger.info(":: Enter into ProductController--------::getProduct()");
		List<ProductResponseDTO> listOfProductCategoryResponseDTO= productService.fetchProduct(categoryId);		
		return new ResponseEntity<>(listOfProductCategoryResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/productDetails/{productId}")
	public ResponseEntity<List<ProductDetailsResponseDTO>> getProductDetails(int productId){
		logger.info(":: Enter into ProductController--------::getProductDetails()");
		List<ProductDetailsResponseDTO> listOfProductResponseDTO = productService.fetchProductDetails(productId);
		return new ResponseEntity<>(listOfProductResponseDTO,HttpStatus.OK);
	}
}
