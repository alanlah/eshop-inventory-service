package com.eshop.eureka.service;

import com.eshop.eureka.pojo.ProductInventory;

public interface ProductInventoryService {

	public void add(ProductInventory productInventory);
	
	public void update(ProductInventory productInventory);
	
	public void delete(Long id);
	
	public ProductInventory findById(Long id);
	
}
