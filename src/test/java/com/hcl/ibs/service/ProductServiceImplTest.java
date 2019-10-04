package com.hcl.ibs.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.ibs.dto.ProductDetailsResponseDTO;
import com.hcl.ibs.dto.ProductResponseDTO;
import com.hcl.ibs.entity.Product;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.repository.ProductCategoryRepository;
import com.hcl.ibs.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@Mock
	ProductCategoryRepository productCategoryRepository;
	@Mock
	ProductRepository productRepository;
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Test
	public void testFetchProductCategory() {
		List<ProductCategory> listOfProductCategory = new ArrayList<>();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(1);
		productCategory.setProductCategoryName("Mortgage");
		listOfProductCategory.add(productCategory);
		
		Mockito.when(productCategoryRepository.findAll()).thenReturn(listOfProductCategory);
		
		List<ProductCategory> actual = productServiceImpl.fetchProductCategory();
		
		assertNotNull(actual);
	}

	
	
	@Test 
	public void testFetchProduct() {
		List<ProductResponseDTO> productName = new ArrayList<>();
		List<Product> listOfProduct = new ArrayList<>();
		Product product = new Product(); 
		product.setCategoryId(1);
		product.setProductDescription("this is ING Banking Solutios API");
		product.setProductId(1);
		product.setProductName("Mortgage");
		listOfProduct.add(product);
		Mockito.when(productRepository.findAllByCategoryId((Mockito.anyInt()))).thenReturn(listOfProduct);

		for(Product eachpr: listOfProduct) {
			ProductResponseDTO productResponseDTO = new ProductResponseDTO(); 
			BeanUtils.copyProperties(eachpr, productResponseDTO);
			productName.add(productResponseDTO);
		} 
		List<ProductResponseDTO> actual = productServiceImpl.fetchProduct(1);
		assertNotNull(actual);

	}
	 
	 

	@Test
	public void testFetchProductDetails() {
		  List<ProductDetailsResponseDTO> listOfProductDetailsResponseDTO = new ArrayList<>();
		  List<Product> listOfProductDetails = new ArrayList<>();
		  Product product= new Product();
		  product.setCategoryId(1);
			product.setProductDescription("this is ING Banking Solutios API");
			product.setProductId(1);
			product.setProductName("Mortgage");
			listOfProductDetails.add(product);
			Mockito.when(productRepository.findAllByProductId((Mockito.anyInt()))).thenReturn(listOfProductDetails);

			for(Product eachPro: listOfProductDetails) {
			  ProductDetailsResponseDTO productDetailsResponseDTO= new ProductDetailsResponseDTO();	
			  BeanUtils.copyProperties(eachPro, productDetailsResponseDTO);
			  listOfProductDetailsResponseDTO.add(productDetailsResponseDTO);
		  }
			
			List<ProductDetailsResponseDTO> actual = productServiceImpl.fetchProductDetails(1);
			assertNotNull(actual);

	}

}
