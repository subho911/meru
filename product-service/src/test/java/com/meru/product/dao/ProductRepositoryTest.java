package com.meru.product.dao;
import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meru.product.entity.Product;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class ProductRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testSaveProduct() {
		Product product = productRepository.save(new Product("MINote3","Mobile","RedMi mobile"));
		
		assertThat(product).hasFieldOrPropertyWithValue("name", "MINote3");
		assertThat(product).hasFieldOrPropertyWithValue("category", "Mobile");
		assertThat(product).hasFieldOrPropertyWithValue("description", "RedMi mobile");
		
		Iterable<Product> products = productRepository.findAll();
		assertThat(products).hasSize(1).contains(product);
	}
	
	@Test
	public void testFindAllProduct() {
		Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
		entityManager.persist(p1);
		
		Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
		entityManager.persist(p2);
		
		Product p3 = new Product("TitanRaga", "Watch", "Wrist Watches");
		entityManager.persist(p3);
		
		Product p4 = new Product("L450", "Laptop", "Lenovo Laptop");
		entityManager.persist(p4);
		
		Product p5 = new Product("S8", "Mobile", "Samsung Mobile");
		entityManager.persist(p5);
		
		Iterable<Product> products = productRepository.findAll();
		assertThat(products).hasSize(5).contains(p1,p2,p3,p4,p5);
	}
	
	@Test
	public void testFindProductById() {
		Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
		entityManager.persist(p1);
		
		Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
		entityManager.persist(p2);
		
		Product p3 = new Product("TitanRaga", "Watch", "Wrist Watches");
		entityManager.persist(p3);
		
		Product p4 = new Product("L450", "Laptop", "Lenovo Laptop");
		entityManager.persist(p4);
		
		Product p5 = new Product("S8", "Mobile", "Samsung Mobile");
		entityManager.persist(p5);
		
		Product product = productRepository.findOne(p3.getId());
		assertThat(product).hasFieldOrPropertyWithValue("name", p3.getName());
		assertThat(product).hasFieldOrPropertyWithValue("category", p3.getCategory());
		assertThat(product).hasFieldOrPropertyWithValue("description", p3.getDescription());
	}
	
	@Test
	public void testRemoveProduct() {
		Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
		entityManager.persist(p1);
		
		Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
		entityManager.persist(p2);
		
		Product p3 = new Product("TitanRaga", "Watch", "Wrist Watches");
		entityManager.persist(p3);
		
		Product p4 = new Product("L450", "Laptop", "Lenovo Laptop");
		entityManager.persist(p4);
		
		Product p5 = new Product("S8", "Mobile", "Samsung Mobile");
		entityManager.persist(p5);
		
		productRepository.delete(p3.getId());
		
		Iterable<Product> products = productRepository.findAll();
		assertThat(products).doesNotContain(p3);
	}
	
	@Test 
	public void testFindByCategory() { 
		Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
		entityManager.persist(p1);
		
		Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
		entityManager.persist(p2);
		
		Product p3 = new Product("TitanRaga", "Watch", "Wrist Watches");
		entityManager.persist(p3);
		
		Product p4 = new Product("L450", "Laptop", "Lenovo Laptop");
		entityManager.persist(p4);
		
		Product p5 = new Product("S8", "Mobile", "Samsung Mobile");
		entityManager.persist(p5);
		
		Iterable<Product> products = productRepository.findByCategory("mobile".toUpperCase());
		
		assertThat(products).hasSize(3).contains(p1, p2, p5);
	 }
	
	@Test 
	public void testFindByName() { 
		 
		Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
		entityManager.persist(p1);
		
		Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
		entityManager.persist(p2);
		
		Product p3 = new Product("TitanRaga", "Watch", "Wrist Watches");
		entityManager.persist(p3);
		
		Product p4 = new Product("L450", "Laptop", "Lenovo Laptop");
		entityManager.persist(p4);
		
		Product p5 = new Product("s6", "Mobile", "Samsung Mobile");
		entityManager.persist(p5);
		
		Iterable<Product> products = productRepository.findByName("S6".toUpperCase());
		assertThat(products).hasSize(2).contains(p5,p1);
		
	 }
	 
	  
	@Test 
	public void testUpdateProduct() { 
		 
		 Product p1 = new Product("S6", "Mobile", "Samsung Mobile");
			entityManager.persist(p1);
			
			Product p2 = new Product("S7", "Mobile", "Samsung Mobile");
			entityManager.persist(p2);
			
			Product p3 = new Product("TitanRaga", "Watch", "Wrist Watches");
			entityManager.persist(p3);
			
			Product p4 = new Product("L450", "Laptop", "Lenovo Laptop");
			entityManager.persist(p4);
			
			Product p5 = new Product("S8", "Mobile", "Samsung Mobile");
			entityManager.persist(p5);
			
			p4.setName(p4.getName()+" Mod");
			p4.setCategory(p4.getCategory()+" Mod");
			p4.setDescription(p4.getDescription()+" Mod");
			
			assertEquals(1, productRepository.updateProduct(p4.getId(), p4.getName(), p4.getCategory(), p4.getDescription()));
			
			Product product = productRepository.findOne(p4.getId());
			
			assertThat(product).hasFieldOrPropertyWithValue("name", p4.getName());
			assertThat(product).hasFieldOrPropertyWithValue("category", p4.getCategory());
			assertThat(product).hasFieldOrPropertyWithValue("description", p4.getDescription());
	 }
	 

}