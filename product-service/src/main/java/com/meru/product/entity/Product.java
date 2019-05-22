package com.meru.product.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(length=20, name="name")
	@NotNull
	@NotEmpty
	String name;
	
	@Column(name="category")
	@NotNull
	@NotEmpty
	String category;
	
	@Column(name="description")
	String description;
	
	
	 public Product(){
	 
	 }
	 	
	public Product(int id, String name, String category, String description){
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
	public Product(String name, String category, String description){
		this.name = name;
		this.category = category;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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
	
	public void setDescription(String descirption) {
		this.description = descirption;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Product Id:"+this.id+" Name:"+this.name+" Category:"+this.category+" Desc:"+this.description;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Product)) {
			return false;
		}
		
		Product p2 = (Product) obj;
		if((this.name == p2.name) && (this.category == p2.category) && (this.description == p2.description)) {
			return true;
		}
		
		return false;
	}
	
}