package com.hcl.ibs.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.hcl.ibs.dto.ProductDetailsResponseDTO;
import com.hcl.ibs.dto.ProductResponseDTO;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.service.ProductService;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@Mock
	ProductService productService;
	
	@InjectMocks
	ProductController productController;
	
	@Test
	public void testGetProductCategoryList() {
	
		List<ProductCategory> listOfProduct = new ArrayList<>();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(1);
		productCategory.setProductCategoryName("Mortgage");
		listOfProduct.add(productCategory);
		
		Mockito.when(productService.fetchProductCategory()).thenReturn(listOfProduct);
		
		
		ResponseEntity<List<ProductCategory>> actual = productController.getProductCategoryList();
		assertNotNull(actual);
	}

	@Test
	public void testGetProduct() {
		
		List<ProductResponseDTO> listOfProductName = new ArrayList<>();
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setProductId(1);
		productResponseDTO.setProductName("Manisha");
		listOfProductName.add(productResponseDTO);
		
		Mockito.when(productService.fetchProduct((Mockito.anyInt()))).thenReturn(listOfProductName);

		ResponseEntity<List<ProductResponseDTO>> actual = productController.getProduct(1);
		assertNotNull(actual);

	}

	@Test
	public void testGetProductDetails() {
		List<ProductDetailsResponseDTO> listOfProductDetails = new ArrayList<>();
		ProductDetailsResponseDTO productDetailsResponseDTO = new ProductDetailsResponseDTO();
		productDetailsResponseDTO.setCategoryId(1);
		productDetailsResponseDTO.setProductDescription("new Mortgage App");
		productDetailsResponseDTO.setProductId(1);
		productDetailsResponseDTO.setProductName("Mortgage");
		listOfProductDetails.add(productDetailsResponseDTO);
		
		Mockito.when(productService.fetchProductDetails((Mockito.anyInt()))).thenReturn(listOfProductDetails);

		ResponseEntity<List<ProductDetailsResponseDTO>> actual = productController.getProductDetails(1);
		assertNotNull(actual);

}

}
