package com.meru.inventoryservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.inventoryservice.dao.InventoryDAO;
import com.meru.inventoryservice.service.InventoryService;
import com.meru.inventoryservice.service.schemaobject.ItemSO;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDAO inventoryDAO;

	@Override
	public List<ItemSO> getAllItems() {
		return inventoryDAO.getAllItems();
	}

	@Override
	public ItemSO getItem(Long id) {
		return inventoryDAO.getItem(id);
	}

	@Override
	public List<ItemSO> getItemByCategory(String category) {
		return inventoryDAO.getItemByCategory(category);
	}

	@Override
	public List<ItemSO> getItemByName(String name) {
		return inventoryDAO.getItemByName(name);
	}

	@Override
	public ItemSO getItemById(int id) {
		return inventoryDAO.getItemById(id);
	}

	@Override
	public void addItem(ItemSO item) {
		inventoryDAO.saveOrUpdateItem(item);
	}

	@Override
	public void updateItem(ItemSO item) {
		inventoryDAO.saveOrUpdateItem(item);
	}

	@Override
	public void removeItem(Long id) {
		inventoryDAO.removeItem(id);
	}

	@Override
	public void updateInventory(Long id, int quantity) {
		inventoryDAO.updateInventory(id, quantity);
	}

}
