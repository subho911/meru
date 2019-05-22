package com.meru.priceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.meru.priceservice.DAO.PriceRepository;
import com.meru.priceservice.entity.Price;

@RestController
public class PriceController {
	
	@Autowired
	PriceRepository priceRepository;
	
	@RequestMapping("/price")
	public Iterable<Price> getPrices(){	
		return priceRepository.findAll();		
	}
	
	@RequestMapping(value="/price/{id}")
	public List<Price> getPriceById(@PathVariable long id) {
		return priceRepository.findById(id);
	}
	
	@RequestMapping(value="/price", method=RequestMethod.POST)
	public Price addPrice(@RequestBody Price price) {
		priceRepository.save(price);
		return price;
	}
	
	@RequestMapping(value="/price", method=RequestMethod.PUT)
	public Price updatePrice(@RequestBody Price price) {
		priceRepository.save(price);
		return price;
	}
	
	@RequestMapping(value="/price", method=RequestMethod.DELETE)
	public String deletePrice(@RequestBody Price price) {
		priceRepository.delete(price);
		return "Entry Deleted";
	}

}
