package com.meru.inventoryservice.dao;

import java.util.List;

import com.meru.inventoryservice.service.schemaobject.ItemSO;

public interface InventoryDAO {

	public List<ItemSO> getAllItems();

	public ItemSO getItem(Long id);

	public List<ItemSO> getItemByCategory(String category);

	public List<ItemSO> getItemByName(String name);

	public ItemSO getItemById(int id);

	public void saveOrUpdateItem(ItemSO item);

	public void removeItem(Long id);

	public void updateInventory(Long id, int quantity);
}
