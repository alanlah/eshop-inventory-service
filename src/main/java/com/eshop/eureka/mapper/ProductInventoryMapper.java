package com.eshop.eureka.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.eshop.eureka.pojo.ProductInventory;

@Mapper
public interface ProductInventoryMapper {

	@Insert("INSERT INTO product_inventory(value,product_id) VALUES(#{value},#{productId})")
	public void add(ProductInventory productInventory);

	@Update("UPDATE product_inventory SET value=#{value},product_id=#{productId} WHERE id=#{id}")
	public void update(ProductInventory productInventory);

	@Delete("DELETE FROM product_inventory WHERE id=#{id}")
	public void delete(Long id);

	@Select("SELECT * FROM product_inventory WHERE id=#{id}")
	@Results({ @Result(column = "product_id", property = "productId") })
	public ProductInventory findById(Long id);

	@Select("select *from product_inventory where product_id =#{productId}")
	@Results({ @Result(column = "product_id", property = "productId") })
	public ProductInventory findByProductId(Long productId);

}
