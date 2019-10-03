package com.hcl.ibs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	@Id
	public int productId;
	public String productName;
	public String productDescription;
	public int categoryId;

}
