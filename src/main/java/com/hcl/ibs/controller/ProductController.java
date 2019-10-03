package com.hcl.ibs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ibs.dto.ProductCategoryResponseDTO;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.service.ProductService;

/**
 * 
 * @author Manisha Yadav
 *
 */

@RestController
@RequestMapping("/ibsApp")
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
//	public List<ProductCategoryResponseDTO> getProductCategoryList() {
	public ResponseEntity<List<ProductCategory>> getProductCategoryList() {

	
		logger.info(":: Enter into ProductController--------::getProductCategoryList()");
	//	List<ProductCategoryResponseDTO> listOfProductCategoryResponseDTO= productService.fetchProductCategory();
		List<ProductCategory> listOfProductCategoryResponseDTO= productService.fetchProductCategory();

	//	return listOfProductCategoryResponseDTO;
		
		return new ResponseEntity<>(listOfProductCategoryResponseDTO, HttpStatus.OK);

		
	}
}
