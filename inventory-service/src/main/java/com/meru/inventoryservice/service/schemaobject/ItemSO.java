package com.meru.inventoryservice.service.schemaobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ItemSO {
	private long id;
	private String name;
	private String category;
	private double price;
	private int quantity;

}
