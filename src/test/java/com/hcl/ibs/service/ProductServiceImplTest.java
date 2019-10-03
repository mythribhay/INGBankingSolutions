package com.hcl.ibs.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

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
	@Mock
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

	
	/*
	 * @Test public void testFetchProduct() { List<ProductResponseDTO> productName =
	 * new ArrayList<>(); List<Product> listOfProduct = new ArrayList<>(); Product
	 * product = new Product(); product.setCategoryId(1);
	 * product.setProductDescription("this is ING Banking Solutios API");
	 * product.setProductId(1); product.setProductName("Mortgage");
	 * listOfProduct.add(product);
	 * Mockito.when(productRepository.findAllByCategoryId((Mockito.anyInt()))).
	 * thenReturn(listOfProduct);
	 * 
	 * List<Product> listOfProduct
	 * =productRepository.findAllByCategoryId(categoryId); for(Product eachpr:
	 * listOfProduct) { ProductResponseDTO productResponseDTO = new
	 * ProductResponseDTO(); BeanUtils.copyProperties(eachpr, productResponseDTO);
	 * productName.add(productResponseDTO); } return productName; }
	 */
	 

	@Test
	public void testFetchProductDetails() {
		fail("Not yet implemented");
	}

}
