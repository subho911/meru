package com.meru.clientservice;

import java.io.Serializable;



public class Price implements Serializable{
	

	private long id;
	private long productId;
	private float priceBeforeDiscount;
	private float discountPercentage;
	private float priceAfterDiscount;
	private String remarks;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public float getPriceBeforeDiscount() {
		return priceBeforeDiscount;
	}
	public void setPriceBeforeDiscount(float priceBeforeDiscount) {
		this.priceBeforeDiscount = priceBeforeDiscount;
	}
	public float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public float getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(float priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
