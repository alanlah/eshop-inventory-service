package com.eshop.eureka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eshop.eureka.mapper.ProductInventoryMapper;
import com.eshop.eureka.pojo.ProductInventory;
import com.eshop.eureka.service.ProductInventoryService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

	@Autowired
	private ProductInventoryMapper productInventoryMapper;
	@Autowired
	private JedisPool jedisPool;
	
	public void add(ProductInventory productInventory) {
		productInventoryMapper.add(productInventory);
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_inventory_" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
	}
	
	public void update(ProductInventory productInventory) {
		productInventoryMapper.update(productInventory); 
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_inventory_" + productInventory.getProductId(), JSONObject.toJSONString(productInventory));
	}

	public void delete(Long id) {
		ProductInventory productInventory = findById(id);
		productInventoryMapper.delete(id); 
		Jedis jedis = jedisPool.getResource();
		jedis.del("product_inventory_" + productInventory.getProductId());
	}

	public ProductInventory findById(Long id) {
		return productInventoryMapper.findById(id);
	}

}
