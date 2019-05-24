package com.meru.inventoryservice.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meru.inventoryservice.dao.InventoryDAO;
import com.meru.inventoryservice.entity.Item;
import com.meru.inventoryservice.repository.ItemRepository;
import com.meru.inventoryservice.service.schemaobject.ItemSO;
import com.meru.inventoryservice.util.InventoryUtil;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

	@Autowired
	ItemRepository itemRepo;

	@Autowired
	InventoryUtil inventoryUtil;

	@Override
	public List<ItemSO> getAllItems() {
		List<Item> items = itemRepo.findAll();
		// item = itemRepo.find
		return inventoryUtil.convertEntityToSO(items);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wipro.inventoryservice.dao.InventoryDAO#getItem(java.lang.Long)
	 */
	@Override
	public ItemSO getItem(Long id) {
		Item item = itemRepo.findByItemId(id);
		// List<Item> lstItem = itemRepo.findById(id);
		// This will
		return inventoryUtil.convertEntityToSO(item);
	}

	@Override
	public List<ItemSO> getItemByCategory(String category) {
		List<Item> items = itemRepo.fetchItemByCategory(category);
		return inventoryUtil.convertEntityToSO(items);
	}

	@Override
	public List<ItemSO> getItemByName(String name) {
		List<Item> items = itemRepo.fetchItemByName(name);
		return inventoryUtil.convertEntityToSO(items);
	}

	@Override
	public ItemSO getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdateItem(ItemSO itemSO) {
		Item item = new Item();
		BeanUtils.copyProperties(itemSO, item);
		itemRepo.save(item);

	}

	@Override
	public void removeItem(Long id) {
		itemRepo.deleteById(id);

	}

	@Override
	public void updateInventory(Long id, int quantity) {
		itemRepo.updateInventory(id, quantity);
	}

}
