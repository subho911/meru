package com.meru.product.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.meru.product.entity.Product;

@Repository("productRepository")
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT P FROM Product P WHERE UPPER(P.name) like %?1%")
	public List<Product> findByName(String name);
	
	@Query("SELECT P FROM Product P WHERE UPPER(P.category) like %?1%")
	public List<Product> findByCategory(String category);
	
	@Modifying
	@Query("update Product p set p.name= :name, p.category= :category, p.description= :description where p.id= :id")
	public int updateProduct(@Param("id") int id, @Param("name") String name, @Param("category") String category, @Param("description") String description);
	
	@Query("SELECT P FROM Product P WHERE UPPER(P.name)=?1 and UPPER(P.category)=?2")
	public Product doesExists(String name, String category);
}