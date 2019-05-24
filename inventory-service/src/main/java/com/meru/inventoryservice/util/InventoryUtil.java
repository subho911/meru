package com.meru.inventoryservice.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.meru.inventoryservice.entity.Item;
import com.meru.inventoryservice.service.schemaobject.ItemSO;

@Component
public class InventoryUtil {

	public List<ItemSO> convertEntityToSO(List<Item> items) {
		List<ItemSO> result = new ArrayList<>();
		for (Item item : items) {
			result.add(convertEntityToSO(item));
		}
		return result;

	}

	public ItemSO convertEntityToSO(Item item) {
		ItemSO itemSO = new ItemSO();
		BeanUtils.copyProperties(item, itemSO);
		return itemSO;
	}
}
