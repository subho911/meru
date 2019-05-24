package com.meru.inventoryservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meru.inventoryservice.entity.Item;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Modifying
	@Query("from Item where name like %:name%")
	List<Item> fetchItemByName(@Param("name") String name);

	@Query("from Item where category = :category")
	List<Item> fetchItemByCategory(@Param("category") String category);

	@Modifying
	@Query("update Item set quantity =:quantity WHERE id = :id")
	void updateInventory(Long id, int quantity);

	@Query("from Item where id = :id")
	Item findByItemId(Long id);

}
