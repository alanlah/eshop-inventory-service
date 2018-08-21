package com.eshop.eureka.pojo;

public class ProductInventory {
	private Long id;
	private Integer value;
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductInventory [id=" + id + ", value=" + value + ", productId=" + productId + "]";
	}

}
