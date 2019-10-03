package com.hcl.ibs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ibs.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
