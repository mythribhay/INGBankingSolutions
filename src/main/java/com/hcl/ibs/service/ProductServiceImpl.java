package com.hcl.ibs.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ibs.controller.ProductController;
import com.hcl.ibs.dto.ProductCategoryResponseDTO;
import com.hcl.ibs.entity.ProductCategory;
import com.hcl.ibs.exception.ProductCategoryNotFound;
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
//	public List<ProductCategoryResponseDTO> fetchProductCategory() {
		public List<ProductCategory> fetchProductCategory() {

		logger.info(":: Enter into ProductServiceImpl--------::fetchProductCategory()");
		List<ProductCategoryResponseDTO> listOfProductCategoryResponseDTO = new ArrayList<>();
		List<ProductCategory> listOfProductCategory =productCategoryRepository.findAll();
	//	BeanUtils.copyProperties(listOfProductCategory, listOfProductCategoryResponseDTO);

		return listOfProductCategory;
	}

}
