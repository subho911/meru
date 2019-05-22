package com.meru.product.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.meru.product.entity.Product;

public class ProductDto {
	
	int id;
	
	@NotEmpty(message="Product Name cannot be null or empty")
	@NotNull(message="Product Name cannot be null or empty")
	@Size(min=1, max=50, message="Name cannot be less than 1 character or more than 20 characters")
	String name;
	
	@NotEmpty(message="Product Category cannot be null or empty")
	@NotNull(message="Product Category cannot be null or empty")
	@Size(min=1, max=50, message="Category cannot be less than 1 character or more than 50 characters")
	String category;
	
	String description;
	
	public ProductDto(){
		
	}
	
	public ProductDto(String name, String category, String description){
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
	public ProductDto(int id, String name, String category, String description){
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Product ID:"+this.getId()+"\nProduct Name:"+this.getName()+"\nProduct Category:"+this.getCategory();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof ProductDto)) {
			return false;
		}
		
		ProductDto p2 = (ProductDto) obj;
		if((this.name == p2.name) && (this.category == p2.category) && (this.description == p2.description)) {
			return true;
		}
		
		return false;
	}
}
