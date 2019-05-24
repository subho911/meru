package com.meru.inventoryservice.service;

import java.util.List;

import com.meru.inventoryservice.service.schemaobject.ItemSO;

public interface InventoryService {

	public List<ItemSO> getAllItems();

	public ItemSO getItem(Long id);

	public List<ItemSO> getItemByCategory(String category);

	public List<ItemSO> getItemByName(String name);

	public ItemSO getItemById(int id);

	public void addItem(ItemSO item);

	public void updateItem(ItemSO item);

	public void removeItem(Long id);

	public void updateInventory(Long id, int quantity);

}
