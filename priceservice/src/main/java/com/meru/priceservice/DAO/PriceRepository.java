package com.meru.priceservice.DAO;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.meru.priceservice.entity.Price;


public interface PriceRepository extends CrudRepository<Price, Long>{

	public List<Price> findById(long id);
}
