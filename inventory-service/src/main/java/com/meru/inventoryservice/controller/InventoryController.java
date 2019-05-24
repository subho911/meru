package com.meru.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meru.inventoryservice.service.InventoryService;
import com.meru.inventoryservice.service.schemaobject.ItemSO;

@RestController
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@RequestMapping("/items")
	public List<ItemSO> getAllItems() {
		return inventoryService.getAllItems();
	}

	@RequestMapping("/items/{id}")
	public ItemSO getItem(@PathVariable Long id) {
		return inventoryService.getItem(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/items")
	public void addItem(@RequestBody ItemSO itemSO) {
		inventoryService.addItem(itemSO);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
	public void updateItem(@PathVariable String id, @RequestBody ItemSO itemSO) {
		inventoryService.updateItem(itemSO);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
	public void removeItem(@PathVariable Long id) {
		inventoryService.removeItem(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/items/{id}/inventory/{quantity}")
	public void updateInventory(@PathVariable Long id, @PathVariable int quantity) {
		inventoryService.updateInventory(id, quantity);
	}

	@RequestMapping("/items/category/{category}")
	public List<ItemSO> getItemByCategory(@PathVariable String category) {
		return inventoryService.getItemByCategory(category);
	}

	@RequestMapping("/items/name/{name}")
	public List<ItemSO> getItemByName(@PathVariable String name) {
		return inventoryService.getItemByName(name);
	}
}
