package com.meru.product.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meru.product.dao.ProductRepository;
import com.meru.product.dto.ProductDto;
import com.meru.product.service.ProductService;
import com.meru.product.util.ProductUtil;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductUtil productUtil;
	
	@Override
	public ProductDto getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productUtil.convertEntityToDto(productRepository.findOne(id));
	}

	@Override
	public List<ProductDto> getProducts() {
		// TODO Auto-generated method stub
		return productUtil.convertEntityToDto(productRepository.findAll());
	}

	@Override
	public List<ProductDto> getProductByName(String name) {
		// TODO Auto-generated method stub
		return productUtil.convertEntityToDto(productRepository.findByName(name.toUpperCase()));
	}

	@Override
	public List<ProductDto> getProductbyCategory(String category) {
		// TODO Auto-generated method stub
		return productUtil.convertEntityToDto(productRepository.findByCategory(category.toUpperCase()));
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		return productUtil.convertEntityToDto(productRepository.save(productUtil.convertDtoToEntity(productDto)));
	}

	@Override
	public void removeProduct(Integer id) {
		// TODO Auto-generated method stub
		productRepository.delete(id);
		
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		int result = productRepository.updateProduct(productDto.getId(), 
													 productDto.getName(), 
													 productDto.getCategory(), 
													 productDto.getDescription());
		
		if(result != 1) {
			return null;
		}
		
		return productDto;
	}

	@Override
	public ProductDto doesExists(ProductDto productDto) {
		// TODO Auto-generated method stub
		return productUtil.convertEntityToDto(
								productRepository.doesExists(productDto.getName().toUpperCase(), 
															 productDto.getCategory().toUpperCase()));
	}
	
}