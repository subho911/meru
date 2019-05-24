package com.meru.inventoryservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Item implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String category;
	private double price;
	private int quantity;

	public Item(String name, String category, double price, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
}
