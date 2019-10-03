package com.hcl.ibs.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ibs.controller.ProductController;
import com.hcl.ibs.dto.ProductDetailsResponseDTO;
import com.hcl.ibs.dto.ProductResponseDTO;
import com.hcl.ibs.entity.Product;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.repository.ProductCategoryRepository;
import com.hcl.ibs.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	/**
	 * 
	 * @param no-parameter
	 * @return ProductCategoryResponseDTO-list of categories of products available in DB
	 */
	
	@Override
		public List<ProductCategory> fetchProductCategory() {

		logger.info(":: Enter into ProductServiceImpl--------::fetchProductCategory()");
	//	List<ProductCategoryResponseDTO> listOfProductCategoryResponseDTO = new ArrayList<>();
		List<ProductCategory> listOfProductCategory =productCategoryRepository.findAll();
	//	BeanUtils.copyProperties(listOfProductCategory, listOfProductCategoryResponseDTO);
		return listOfProductCategory;
	}

	/**
	 * 
	 * @param categoryId
	 * @return ProductResponseDTO - list of product Name related to that specific category
	 */
	@Override
		public List<ProductResponseDTO> fetchProduct(int categoryId) {
		logger.info(":: Enter into ProductServiceImpl--------::fetchProduct()");
		List<ProductResponseDTO> productName = new ArrayList<>();		
		List<Product> listOfProduct =productRepository.findAllByCategoryId(categoryId);
		for(Product eachpr: listOfProduct) {	
		ProductResponseDTO productResponseDTO = new ProductResponseDTO();
		BeanUtils.copyProperties(eachpr, productResponseDTO);
		productName.add(productResponseDTO);
		}
		return productName;
	}

	/**
	 * 
	 * @param productId
	 * @return ProductDetailsResponseDTO - productDetials
	 */
	  @Override 
	  public List<ProductDetailsResponseDTO> fetchProductDetails(int productId) {
	  List<ProductDetailsResponseDTO> listOfProductDetailsResponseDTO = new ArrayList<>();
	  List<Product> listOfProductDetails = productRepository.findAllByProductId(productId);
	  for(Product eachPro: listOfProductDetails) {
		  ProductDetailsResponseDTO productDetailsResponseDTO= new ProductDetailsResponseDTO();	
		  BeanUtils.copyProperties(eachPro, productDetailsResponseDTO);
		  listOfProductDetailsResponseDTO.add(productDetailsResponseDTO);
	  }
	  return listOfProductDetailsResponseDTO;
	  }
}
